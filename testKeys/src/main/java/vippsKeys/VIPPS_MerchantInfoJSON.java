package vippsKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VIPPS_MerchantInfoJSON {

@SerializedName("merchantSerialNumber")
@Expose
private String merchantSerialNumber;
@SerializedName("callbackPrefix")
@Expose
private String callbackPrefix;
@SerializedName("fallBack")
@Expose
private String fallBack;
@SerializedName("isApp")
@Expose
private Boolean isApp;

public String getMerchantSerialNumber() {
return merchantSerialNumber;
}

public void setMerchantSerialNumber(String merchantSerialNumber) {
this.merchantSerialNumber = merchantSerialNumber;
}

public String getCallbackPrefix() {
return callbackPrefix;
}

public void setCallbackPrefix(String callbackPrefix) {
this.callbackPrefix = callbackPrefix;
}

public String getFallBack() {
return fallBack;
}

public void setFallBack(String fallBack) {
this.fallBack = fallBack;
}

public Boolean getIsApp() {
return isApp;
}

public void setIsApp(Boolean isApp) {
this.isApp = isApp;
}

}