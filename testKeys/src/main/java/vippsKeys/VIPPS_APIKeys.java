package vippsKeys;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class VIPPS_APIKeys {

  private static Random r = new Random();

  public static String orderId = "" + r.nextInt(5000);
  public static String mobileNumber;
  public static String merchantSerialNumber;
  public static String producturi;
  public static String productSubscriptionKey;
  public static String accesstokenuri;
  public static String clientId;
  public static String clientSecret;
  public static String accessTokenSubscriptionKey;
  public static String urlRoot;

  public static void incrementOrderId() {

    orderId = "" + (Integer.parseInt(orderId) + 1);
  }

  public static void readKeys() throws IOException {
    File initialFile = new File("input.json");
    try (InputStream input = new FileInputStream(initialFile)) {
      StringBuilder inputKeysFromJson = new StringBuilder();
      int c;
      while ((c = input.read()) != -1) {
        inputKeysFromJson.append((char) c);
        System.out.print((char) c);
      }

      Gson gson = new Gson();
      KeysContainerJSON keysContainer =
          gson.fromJson(inputKeysFromJson.toString(), KeysContainerJSON.class);

      mobileNumber = keysContainer.getMobileNumber();
      merchantSerialNumber = keysContainer.getMerchantSerialNumber();
      producturi = keysContainer.getProducturi();
      productSubscriptionKey = keysContainer.getProductSubscriptionKey();
      accesstokenuri = keysContainer.getAccesstokenuri();
      clientId = keysContainer.getClientId();
      clientSecret = keysContainer.getClientSecret();
      accessTokenSubscriptionKey = keysContainer.getAccessTokenSubscriptionKey();
      urlRoot = keysContainer.getUrlRoot();
    }
  }
}
