package vippsKeys;

import com.google.gson.*;
import java.io.IOException;

public class VIPPS_getAccessToken {

  private HttpRequest request;
  private VIPPS_AccessTokenJSON accesstokenjson;

  public VIPPS_getAccessToken() {

    String[] headers =
        new String[] {
          ("POST " + VIPPS_APIKeys.accesstokenuri + " HTTP/1.1"),
          ("Host: " + VIPPS_APIKeys.urlRoot),
          ("client_id: " + VIPPS_APIKeys.clientId),
          ("client_secret: " + VIPPS_APIKeys.clientSecret),
          ("Ocp-Apim-Subscription-Key: " + VIPPS_APIKeys.accessTokenSubscriptionKey),
          ("Content-Length: 0")
        };

    request = new HttpRequest(headers, VIPPS_APIKeys.urlRoot, "");
  }

  protected String fetchAccessToken() throws IOException {
    fillAccessTokenObject(execute());
    return accesstokenjson.getAccessToken();
  }

  private HttpResponse execute() throws IOException {
    return request.executeSSL();
  }

  private void fillAccessTokenObject(HttpResponse response) {
    Gson gson = new Gson();
    accesstokenjson = gson.fromJson(response.getBody(), VIPPS_AccessTokenJSON.class);
  }
}
