package vippsKeys;

import java.util.HashMap;

public class HttpResponse {

  HashMap<String, String> headers;
  String body;

  // Constructor opens HashMap and temporary String array for converting headers. Will store header
  // parameter as key (without colon), and
  // store header content as value(including everything after first space). Stops reading at
  // "Connection: close" to avoid nullpointerexception.
  // @param response is String separating lines by "\r\n".

  public HttpResponse(String response) {
    if (response == null || response.equals(""))
      throw new IllegalArgumentException("Empty response from HttpRequest");

    headers = new HashMap<String, String>();
    String[] headerLineSplits;
    String[] headerLines = response.split("\r\n");

    // For loops puts all headers in headers HashMap and when it reaches the end put body in String
    // body

    for (int i = 0; i < headerLines.length; i++) {

      // Look for Json objects
      if (headerLines[i].startsWith("{")
          && headers.get("Content-Type").startsWith("application/json")) {
        body = headerLines[i];
      }
      // If headerline is empty, skip one iteration
      else if (headerLines[i].equals("")) continue;
      else {
        // If header is valid and has key + value
        if (headerLines[i].split(" ", 2).length > 1) {
          headerLineSplits = headerLines[i].split(" ", 2);
          headers.put(headerLineSplits[0].replaceFirst(":", ""), headerLineSplits[1]);
        }
        // else put key with empty value
        else {
          headers.put(headerLines[i], "");
        }
      }
    }
  }

  // Will fetch statusCode by searching getHeader and splitting the actual code from the message.
  // Error might show if there is no " " to split on? Not sure.
  public int getStatusCode() {
    return Integer.parseInt(getHeader("HTTP/1.1").split(" ")[0]);
  }

  // getHeader check if input is valid and then searches the HashMap for the key and returns the
  // corresponding value
  // @param headerName must be identical to Key in HashMap as withdrawn from response.
  public String getHeader(String headerName) {
    if (headerName == null || headerName == "") return null;
    for (HashMap.Entry<String, String> head : headers.entrySet()) {
      if (head.getKey().equals(headerName)) return head.getValue();
    }
    return null;
  }

  // return body
  public String getBody() {
    return body;
  }
}
