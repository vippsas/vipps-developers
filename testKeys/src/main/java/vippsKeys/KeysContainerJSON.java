package vippsKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeysContainerJSON {

  @SerializedName("mobileNumber")
  @Expose
  private String mobileNumber;

  @SerializedName("merchantSerialNumber")
  @Expose
  private String merchantSerialNumber;

  @SerializedName("producturi")
  @Expose
  private String producturi;

  @SerializedName("productSubscriptionKey")
  @Expose
  private String productSubscriptionKey;

  @SerializedName("accesstokenuri")
  @Expose
  private String accesstokenuri;

  @SerializedName("clientId")
  @Expose
  private String clientId;

  @SerializedName("clientSecret")
  @Expose
  private String clientSecret;

  @SerializedName("accessTokenSubscriptionKey")
  @Expose
  private String accessTokenSubscriptionKey;

  @SerializedName("urlRoot")
  @Expose
  private String urlRoot;

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getMerchantSerialNumber() {
    return merchantSerialNumber;
  }

  public void setMerchantSerialNumber(String merchantSerialNumber) {
    this.merchantSerialNumber = merchantSerialNumber;
  }

  public String getProducturi() {
    return producturi;
  }

  public void setProducturi(String producturi) {
    this.producturi = producturi;
  }

  public String getProductSubscriptionKey() {
    return productSubscriptionKey;
  }

  public void setProductSubscriptionKey(String productSubscriptionKey) {
    this.productSubscriptionKey = productSubscriptionKey;
  }

  public String getAccesstokenuri() {
    return accesstokenuri;
  }

  public void setAccesstokenuri(String accesstokenuri) {
    this.accesstokenuri = accesstokenuri;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getAccessTokenSubscriptionKey() {
    return accessTokenSubscriptionKey;
  }

  public void setAccessTokenSubscriptionKey(String accessTokenSubscriptionKey) {
    this.accessTokenSubscriptionKey = accessTokenSubscriptionKey;
  }

  public String getUrlRoot() {
    return urlRoot;
  }

  public void setUrlRoot(String urlRoot) {
    this.urlRoot = urlRoot;
  }
}
