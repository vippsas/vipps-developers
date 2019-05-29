package main

import (
	"bufio"
	"bytes"
	"encoding/json"
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"strings"
	"time"
)

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

var orderIdFilePath string
var configFilePath string
var doCapture bool
var doDetails bool
var production bool

func init() {
	flag.BoolVar(&doCapture, "capture", false, "Specify this flag to perform CAPTURE on Orders specified in -orders fileName")
	flag.BoolVar(&doDetails, "detail", false, "Specify this flag to perform a DETAILS request on Orders specified in -orders fileName")
	flag.BoolVar(&production, "production", false, "Specify to use the production environment. Otherwise it will default to Test (MT)")
	flag.StringVar(&orderIdFilePath, "o", "", "Path to file text file with Order IDs'")
	flag.StringVar(&orderIdFilePath, "orders", "", "Path to file text file with Order IDs'")
	flag.StringVar(&configFilePath, "c", "", "Path to file configuration file to use")
	flag.StringVar(&configFilePath, "conf", "", "Path to file configuration file to use")
}

func main() {
	flag.Parse()
	fmt.Println("FilePath:", orderIdFilePath)
	if orderIdFilePath == "" || configFilePath == "" {
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

	// Read in the order IDs
	orderIds, err := readOrderIdFile(orderIdFilePath)
	if err != nil {
		log.Printf("Error during reading of OrderID file, %v", err)
		os.Exit(1)
	}
	fmt.Printf("Lines in OrderID file (some might be empty): %v\n", len(orderIds))
	
	fetchAccessToken(config)

	if doCapture {
		performCaptures(config, orderIds)
	} else if doDetails {
		performDetails(config, orderIds)
	}
}

func performDetails(config *Configuration, orderIds []string) {
	/*client := &http.Client{}
	for _, orderId := range orderIds {
		// Remove leading and trailing whitespaces, then check if orderId is empty.
		orderId = strings.TrimSpace(orderId)
		if orderId == "" {
			emptyLinesCount++
			continue
		}

		url := fmt.Sprintf("https://apitest.vipps.no/ecomm/v2/payments/%v/details", orderId)
		request, err := http.NewRequest("GET", url, bytes.NewBuffer())
		if err != nil {
			log.Println("capture->error: ", err)
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
			failedCaptures = append(failedCaptures, orderId)
			return
		}
	}*/
}

func performCaptures(config *Configuration, orderIds []string) {
	// Initializing capture request struct
	captureReq := CaptureRequest{
		MerchantInfo: MerchantInfo{
			MerchantSerialNumber: config.MSN,
		},
		Transaction: Transaction{
			// Amount set to 0 to capture the entire amount available.
			Amount:          0,
			TransactionText: "Captured by Vipps Integration",
		},
	}
	reqBody, err := json.Marshal(captureReq)
	if err != nil {
		log.Printf("Error marshalling request body: %v\n", err)
	}
	var baseUrl string
	if production {
		baseUrl = "https://api.vipps.no"
	} else {
		baseUrl = "https://apitest.vipps.no"
	}

	var emptyLinesCount int
	var failedCapturesCount int
	var failedCaptures []string
	var capturedCount int
	var captured []string
	client := &http.Client{}
	for _, orderId := range orderIds {
		// Remove leading and trailing whitespaces, then check if orderId is empty.
		orderId = strings.TrimSpace(orderId)
		if orderId == "" {
			emptyLinesCount++
			continue
		}

		url := fmt.Sprintf(baseUrl+"/ecomm/v2/payments/%v/capture", orderId)
		request, err := http.NewRequest("POST", url, bytes.NewBuffer(reqBody))
		if err != nil {
			log.Println("capture->error: ", err)
			failedCapturesCount++
			failedCaptures = append(failedCaptures, orderId)
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
			failedCaptures = append(failedCaptures, orderId)
			return
		}

		data, _ := ioutil.ReadAll(response.Body)
		err = response.Body.Close()
		if err != nil {
			log.Println("Error when closing http body:", err)
		}

		// If the HTTP Status Code is anything but a 2xx code we know something went wrong
		// and we didn't manage to perform a capture
		if response.StatusCode > 299 || response.StatusCode < 200 {
			var er []ErrorResponse
			err = json.Unmarshal(data, &er)
			failedCapturesCount++
			failedCaptures = append(failedCaptures, orderId)
			if err != nil {
				log.Printf("Decoding error: %v => '%v'\n", err, string(data))
				continue
			}
			fmt.Printf("%v;%v;%v;%v\n", orderId, er[0].ErrorCode, er[0].ErrorGroup, er[0].ErrorMessage)
			continue
		} else {
			cr := CaptureResponse{}
			err = json.Unmarshal(data, &cr)
			if err != nil {
				log.Fatal("Decoding error: ", err, string(data))
			}
			if cr.TransInfo.Status == "Captured" {
				capturedCount++
				captured = append(captured, orderId)
			}
			fmt.Printf("%v;%v;%v;%v\n", cr.OrderId, cr.TransInfo.Status, cr.TransSummary.CapturedAmount, cr.TransSummary.RemainingAmountToCapture)

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

/*
Reads the file with the order IDs into memory
*/
func readOrderIdFile(path string) ([]string, error) {
	file, err := os.Open(path)
	if err != nil {
		return nil, err
	}
	defer func() {
		err := file.Close()
		if err != nil {
			log.Println("Error while closing order file, ", err)
		}
	}()

	var lines []string
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	return lines, scanner.Err()
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
			log.Println("Erorr while closing HTTP response body:", err)
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
// Details Request structs
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
