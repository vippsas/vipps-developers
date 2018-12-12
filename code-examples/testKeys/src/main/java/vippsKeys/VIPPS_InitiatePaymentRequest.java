package vippsKeys;

import com.google.gson.Gson;
import java.io.IOException;

public class VIPPS_InitiatePaymentRequest {

  VIPPS_InitiatePaymentJSON ipObject = new VIPPS_InitiatePaymentJSON();
  VIPPS_MerchantInfoJSON miObject = new VIPPS_MerchantInfoJSON();
  VIPPS_TransactionJSON trObject = new VIPPS_TransactionJSON();
  VIPPS_CustomerInfoJSON ciObject = new VIPPS_CustomerInfoJSON();
  String orderId, deeplink;

  HttpResponse response;

  public VIPPS_InitiatePaymentRequest() {
    miObject.setMerchantSerialNumber(VIPPS_APIKeys.merchantSerialNumber);
    miObject.setFallBack("http://www.vipps.no");
    miObject.setIsApp(false);
    miObject.setCallbackPrefix("http://www.vipps.no");

    trObject.setAmount("50000");
    trObject.setOrderId(VIPPS_APIKeys.orderId);
    trObject.setTransactionText("text of transaction");

    ciObject.setMobileNumber(VIPPS_APIKeys.mobileNumber);

    ipObject.setCustomerInfo(ciObject);
    ipObject.setMerchantInfo(miObject);
    ipObject.setTransaction(trObject);
  }

  public boolean initiatePayment(String accesstoken) throws IOException {
    HttpRequest request;
    Gson gson = new Gson();
    String body = gson.toJson(ipObject);

    String[] headers =
        new String[] {
          ("POST " + VIPPS_APIKeys.producturi + " HTTP/1.1"),
          ("Host: " + VIPPS_APIKeys.urlRoot),
          ("Authorization: Bearer " + accesstoken),
          ("Ocp-Apim-Subscription-Key: " + VIPPS_APIKeys.productSubscriptionKey),
          ("Content-Type: " + "application/json"),
          ("Content-Length: " + body.length())
        };

    request = new HttpRequest(headers, VIPPS_APIKeys.urlRoot, body);
    response = request.executeSSL();

    VIPPS_InitiatePaymentResponseJSON ipr =
        gson.fromJson(response.getBody(), VIPPS_InitiatePaymentResponseJSON.class);
    try {
      deeplink = ipr.getUrl();
      orderId = ipr.getOrderId();
      return true;
    } catch (NullPointerException e) {
      System.out.println("Didnt get URL or Order from Initiate Payment!");
      return false;
    }
  }

  public String getDeeplinkUrl() {
    System.out.println(deeplink);
    return deeplink;
  }
}
