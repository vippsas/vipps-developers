package main

import (
	"bytes"
	"encoding/csv"
	"encoding/json"
	"errors"
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"strconv"
	"strings"
	"time"
)

type OrderInput struct {
	OrderID       string
	CaptureAmount int
}

type CaptureResponse struct {
	OrderId      string             `json:"orderId"`
	TransInfo    TransactionInfo    `json:"transactionInfo"`
	TransSummary TransactionSummary `json:"transactionSummary"`
}

type TransactionInfo struct {
	Amount          int    `json:"amount"`
	TimeStamp       string `json:"timeStamp"`
	TransactionText string `json:"transactionText"`
	Status          string `json:"status"`
	TransactionId   string `json:"transactionId"`
}

type TransactionSummary struct {
	CapturedAmount           int `json:"capturedAmount"`
	RemainingAmountToCapture int `json:"remainingAmountToCapture"`
	RefundedAmount           int `json:"refundedAmount"`
	RemainingAmountToRefund  int `json:"remainingAmountToRefund"`
}

type CaptureRequest struct {
	MerchantInfo MerchantInfo `json:"merchantInfo"`
	Transaction  Transaction  `json:"transaction"`
}
type MerchantInfo struct {
	MerchantSerialNumber string `json:"merchantSerialNumber"`
}
type Transaction struct {
	Amount          int    `json:"amount"`
	TransactionText string `json:"transactionText"`
}

type ErrorResponse struct {
	ErrorGroup   string `json:"errorGroup"`
	ErrorCode    string `json:"errorCode"`
	ErrorMessage string `json:"errorMessage"`
}

var ordersFilePath string
var configFilePath string
var doCapture bool
var doDetails bool
var production bool

func init() {
	flag.BoolVar(&doCapture, "capture", false, "Specify this flag to perform CAPTURE on Orders specified in -orders fileName")
	flag.BoolVar(&doDetails, "detail", false, "Specify this flag to perform a DETAILS request on Orders specified in -orders fileName")
	flag.BoolVar(&production, "production", false, "Specify to use the production environment. Otherwise it will default to Test (MT)")
	flag.StringVar(&ordersFilePath, "o", "", "Path to file text file with Order IDs'")
	flag.StringVar(&ordersFilePath, "orders", "", "Path to file text file with Order IDs'")
	flag.StringVar(&configFilePath, "c", "", "Path to file configuration file to use")
	flag.StringVar(&configFilePath, "conf", "", "Path to file configuration file to use")
}

func main() {
	flag.Parse()
	fmt.Println("FilePath:", ordersFilePath)
	if ordersFilePath == "" || configFilePath == "" {
		flag.PrintDefaults()
		os.Exit(1)
	}
	if !doCapture && !doDetails {
		fmt.Println("You must specify either '-capture' or '-detail'.")
		flag.PrintDefaults()
		os.Exit(1)
	}
	if production {
		fmt.Println("!!!CURRENTLY RUNNING IN PRODUCTION!!!")
	} else {
		fmt.Println("--- RUNNING IN TEST ENVIRONMENT (MT) ---")
	}

	config := readConfig(configFilePath)

	orders, err, notParsedLines := readOrderIdCsvFile(ordersFilePath)
	if err != nil {
		log.Println(err)
		os.Exit(1)
	}

	// If we have lines that have not been parsed we should let the user know.
	if len(notParsedLines) > 0 {
		fmt.Println("********************************************\n" +
			"* Lines we could for some reason not parse *\n" +
			"********************************************")
		for _, line := range notParsedLines {
			fmt.Printf("%v\n", line)
		}
		fmt.Println("Finished listing lines we couldn't parse.")
	}

	fetchAccessToken(config)

	if doCapture {
		performCaptures(config, orders)
	} else if doDetails {
		performDetails(config, orders)
	}
}

func performDetails(config *Configuration, orders []OrderInput) {
	var baseUrl string
	if production {
		baseUrl = "https://api.vipps.no"
	} else {
		baseUrl = "https://apitest.vipps.no"
	}

	resultFile, err := os.Create(fmt.Sprintf("detailsResults_%v_%v.txt", config.MSN, time.Now().UnixNano()/1000000))
	if err != nil {
		log.Fatal("Cannot create file", err)
	}
	defer resultFile.Close()

	var failedDetailsRequestCount = 0
	var failedDetails []OrderInput

	var headerWritten = false
	client := &http.Client{}
	for _, order := range orders {

		url := fmt.Sprintf("%v/ecomm/v2/payments/%v/details", baseUrl, order.OrderID)
		request, err := http.NewRequest("GET", url, nil)
		if err != nil {
			log.Println("details->error: ", err)
			return
		}
		// Standard HTTP headers required for using the eCom v2 API.
		request.Header.Add("Authorization", config.BearerToken)
		request.Header.Add("Ocp-Apim-Subscription-Key", config.EComSubscriptionKey)
		request.Header.Add("Content-Type", "application/json")

		response, err := client.Do(request)
		if err != nil {
			log.Println("doRequest:", err)
			failedDetailsRequestCount++
			failedDetails = append(failedDetails, order)
			continue
		}
		data, _ := ioutil.ReadAll(response.Body)
		err = response.Body.Close()
		if err != nil {
			log.Println("Error when closing http body:", err)
		}
		// If the HTTP Status Code is anything but a 2xx code we know something went wrong
		// and we didn't manage to perform a capture
		if response.StatusCode > 299 || response.StatusCode < 200 {
			fmt.Printf("error, http status code for '%v' is '%v' with status message: '%v'\n", nil, response.StatusCode, response.Status)
			continue
		} else {
			dr := DetailsResponse{}
			err = json.Unmarshal(data, &dr)
			if err != nil {
				log.Fatal("Decoding error: ", err, string(data))
			}

			if !headerWritten {
				header := "Order ID;Captured Amount;Uncaptured Amount Remaining;Refunded Amount;Remaining Amount available for refund;LastTransaction ID;LastTransaction Operation;LastTransaction TimeStamp;LastTransaction Amount"
				fmt.Println(header)
				fmt.Fprintln(resultFile, header)
				headerWritten = true
			}
			ts := dr.TransactionSummary
			lle := dr.TransactionLogHistory[0]
			output := fmt.Sprintf("%v;%v;%v;%v;%v;%v;%v;%v;%v\n", dr.OrderID, ts.CapturedAmount, ts.RemainingAmountToCapture, ts.RefundedAmount, ts.RemainingAmountToRefund, lle.TransactionID, lle.Operation, lle.TimeStamp, lle.Amount)

			fmt.Fprint(resultFile, output)
			fmt.Print(output)
		}

	}
}

func performCaptures(config *Configuration, orders []OrderInput) {
	// NOTE Doesn't check that access token is valid, though with a 24 hour lifespan in production this isn't likely to ever be an actual issue.
	// TODO Handle potential error in writing results to file

	var baseUrl string
	if production {
		baseUrl = "https://api.vipps.no"
	} else {
		baseUrl = "https://apitest.vipps.no"
	}

	// File we write the results of the captures too.
	resultFile, err := os.Create(fmt.Sprintf("captureResults_%v_%v.txt", config.MSN, time.Now().UnixNano()/1000000))
	if err != nil {
		log.Fatal("Cannot create file", err)
	}
	defer resultFile.Close()

	var failedCapturesCount int
	var failedCaptures []string
	var capturedCount int
	var captured []string
	client := &http.Client{}
	var headerWritten = false
	for _, order := range orders {
		// Initializing capture request struct
		captureReq := CaptureRequest{
			MerchantInfo: MerchantInfo{
				MerchantSerialNumber: config.MSN,
			},
			Transaction: Transaction{
				Amount:          order.CaptureAmount,
				TransactionText: "Captured by Vipps Integration",
			},
		}
		reqBody, err := json.Marshal(captureReq)
		if err != nil {
			log.Printf("Error marshalling request body: %v\n", err)
		}

		url := fmt.Sprintf(baseUrl+"/ecomm/v2/payments/%v/capture", order.OrderID)
		request, err := http.NewRequest("POST", url, bytes.NewBuffer(reqBody))
		if err != nil {
			log.Println("capture->error: ", err)
			failedCapturesCount++
			failedCaptures = append(failedCaptures, order.OrderID)
			return
		}

		// Standard HTTP headers required for using the eCom v2 API.
		request.Header.Add("Authorization", config.BearerToken)
		request.Header.Add("Ocp-Apim-Subscription-Key", config.EComSubscriptionKey)
		request.Header.Add("Content-Type", "application/json")

		response, err := client.Do(request)
		if err != nil {
			log.Println("doRequest:", err)
			failedCapturesCount++
			failedCaptures = append(failedCaptures, order.OrderID)
			return
		}

		data, _ := ioutil.ReadAll(response.Body)
		err = response.Body.Close()
		if err != nil {
			log.Println("Error when closing http body:", err)
		}
		if !headerWritten {
			header := "Order ID;Transaction Status;Captured Amount;Uncaptured Amount Remaining"
			fmt.Println(header)
			fmt.Fprintln(resultFile, header)
			headerWritten = true
		}
		// If the HTTP Status Code is anything but a 2xx code we know something went wrong
		// and we didn't manage to perform a capture
		if response.StatusCode > 299 || response.StatusCode < 200 {
			var er []ErrorResponse
			err = json.Unmarshal(data, &er)
			failedCapturesCount++
			failedCaptures = append(failedCaptures, order.OrderID)
			if err != nil {
				log.Printf("Decoding error: %v => '%v'\n", err, string(data))
				continue
			}
			outputString := fmt.Sprintf("%v;%v;%v;%v\n", order.OrderID, er[0].ErrorCode, er[0].ErrorGroup, er[0].ErrorMessage)
			fmt.Print(outputString)
			fmt.Fprint(resultFile, outputString)
			continue
		} else {
			cr := CaptureResponse{}
			err = json.Unmarshal(data, &cr)
			if err != nil {
				log.Fatal("Decoding error: ", err, string(data))
			}
			if cr.TransInfo.Status == "Captured" {
				capturedCount++
				captured = append(captured, order.OrderID)
			}

			outputString := fmt.Sprintf("%v;%v;%v;%v\n", cr.OrderId, cr.TransInfo.Status, cr.TransSummary.CapturedAmount, cr.TransSummary.RemainingAmountToCapture)
			fmt.Print(outputString)
			fmt.Fprint(resultFile, outputString)
		}
	}

	fmt.Printf("Captured: %v orders. Failed to capture: %v\n", capturedCount, failedCapturesCount)
	if failedCapturesCount > 0 {
		fmt.Printf("Failed to capture the following orders:\n%v", strings.Join(failedCaptures, "\n"))
		fmt.Println()
	}

	if capturedCount > 0 {
		fmt.Printf("Captured the following orders:\n%v", strings.Join(captured, "\n"))
	}
}

// Configuration struct to contain API keys in addition to client id and secret
type Configuration struct {
	AccessToken         string `json:"access_token"`
	EComSubscriptionKey string `json:"ecom_subscription_key"`
	ClientID            string `json:"client_id"`
	ClientSecret        string `json:"client_secret"`
	MSN                 string `json:"msn"`
	BearerToken         string
}

func fetchAccessToken(config *Configuration) {
	client := &http.Client{}
	var baseUrl string
	if production {
		baseUrl = "https://api.vipps.no"
	} else {
		baseUrl = "https://apitest.vipps.no"
	}
	request, err := http.NewRequest("POST", baseUrl+"/accessToken/get", bytes.NewReader([]byte("")))
	if err != nil {
		log.Println("fetchAccessToken->error: ", err)
		return
	}
	request.Header.Add("client_id", config.ClientID)
	request.Header.Add("client_secret", config.ClientSecret)
	request.Header.Add("Ocp-Apim-Subscription-Key", config.AccessToken)

	response, err := client.Do(request)
	if err != nil {
		log.Println("doRequest:", err)
		return
	}

	defer func() {
		err := response.Body.Close()
		if err != nil {
			log.Println("Error while closing HTTP response body:", err)
		}
	}()

	httpData, _ := ioutil.ReadAll(response.Body)
	if response.StatusCode > 299 || response.StatusCode < 200 {
		fmt.Println("HTTP Response Code for fetching access token:", response.StatusCode)
		fmt.Println("Message:", string(httpData))
		os.Exit(1)
	}

	var data map[string]string
	err = json.Unmarshal(httpData, &data)
	if err != nil {
		log.Println(string(httpData))
		panic(err)
	}
	config.BearerToken = data["access_token"]
}

/**
* Reads in the Vipps API keys from configuration file in JSON format
* The keys can be found at https://apitest-portal.vipps.no/ for our Merchant Test (MT) environment.
* For production they can be found at https://api-portal.vipps.no/
 */
func readConfig(path string) *Configuration {
	configFile, err := os.Open(path)
	if os.IsNotExist(err) {
		log.Println("error opening configuration file:", err)
		return nil
	}
	// Read JSON data from file
	decoder := json.NewDecoder(configFile)
	configuration := Configuration{}
	err = decoder.Decode(&configuration)
	if err != nil {
		log.Println("error:", err)
	}
	// Print out contents the configuration struct
	//fmt.Printf("Configuration: %v\n", configuration)
	return &configuration
}

//
// Details Request struct
type DetailsResponse struct {
	OrderID               string                  `json:"orderId"`
	TransactionSummary    TransactionSummary      `json:"transactionSummary"`
	TransactionLogHistory []TransactionLogHistory `json:"transactionLogHistory"`
}

type TransactionLogHistory struct {
	Amount           int       `json:"amount"`
	TransactionText  string    `json:"transactionText"`
	TransactionID    string    `json:"transactionId"`
	TimeStamp        time.Time `json:"timeStamp"`
	Operation        string    `json:"operation"`
	RequestID        string    `json:"requestId"`
	OperationSuccess bool      `json:"operationSuccess"`
}

func readOrderIdCsvFile(path string) ([]OrderInput, error, [][]string) {
	// TODO Handle quotation marks in header and rows.
	// TODO Ensure that user hasn't forgotten to strip away decimal point/comma and/or other separators and currency marks.
	// TODO Lookup rules for OrderID and which characters are allowed

	file, err := os.Open(path)
	if err != nil {
		return make([]OrderInput, 0), err, make([][]string, 0)
	}
	defer func() {
		err := file.Close()
		if err != nil {
			log.Println("Error while closing order CSV file,", err)
		}
	}()

	reader := csv.NewReader(file)
	reader.Comma = ';'
	lines, err := reader.ReadAll()
	if err != nil {
		panic(err)
	}

	// Verify that we actually have a file with something more than a header or an empty file
	if len(lines) <= 1 {
		// Might be just as well to just throw a nil instead of OrderInput with size 0.
		return make([]OrderInput, 0), errors.New("input order file contains 1 or 0 entries. Need HEADER (column names) and rows with data"), make([][]string, 0)
	}

	// Figure out in which order the columns are defined.
	var orderIdCol = -1
	var orderCapAmountCol = -1
	header := lines[0]
	for i, column := range header {
		switch column {
		case "OrderID":
			orderIdCol = i
		case "CaptureAmount":
			orderCapAmountCol = i
		}
	}
	if orderIdCol == -1 || orderCapAmountCol == -1 {
		return make([]OrderInput, 0), errors.New("column marked 'OrderID' AND 'CaptureAmount' MUST exist in orders file"), make([][]string, 0)
	}

	// Read orders into OrderInput struct, and do some checks on content
	var orders []OrderInput
	var notParsedLines [][]string

	for _, line := range lines[1:] {
		if len(strings.TrimSpace(line[orderIdCol])) == 0 {
			fmt.Printf("Empty OrderID not allowed. Complete line:'%v'\n", line)
			notParsedLines = append(notParsedLines, line)
			continue
		}

		amount, err := strconv.Atoi(line[orderCapAmountCol])
		if err != nil {
			fmt.Printf("Error while converting '%v' to int, error: %v\t\n", line[orderCapAmountCol], err)
			notParsedLines = append(notParsedLines, line)
			continue
		}
		// Finally we create the struct with the order line
		order := OrderInput{
			OrderID:       line[orderIdCol],
			CaptureAmount: amount,
		}
		orders = append(orders, order)
	}

	return orders, err, notParsedLines
}
