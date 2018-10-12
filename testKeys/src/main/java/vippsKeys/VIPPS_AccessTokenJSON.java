package vippsKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VIPPS_AccessTokenJSON {

@SerializedName("token_type")
@Expose
private String tokenType;
@SerializedName("expires_in")
@Expose
private String expiresIn;
@SerializedName("ext_expires_in")
@Expose
private String extExpiresIn;
@SerializedName("expires_on")
@Expose
private String expiresOn;
@SerializedName("not_before")
@Expose
private String notBefore;
@SerializedName("resource")
@Expose
private String resource;
@SerializedName("access_token")
@Expose
private String accessToken;

public String getTokenType() {
return tokenType;
}

public void setTokenType(String tokenType) {
this.tokenType = tokenType;
}

public String getExpiresIn() {
return expiresIn;
}

public void setExpiresIn(String expiresIn) {
this.expiresIn = expiresIn;
}

public String getExtExpiresIn() {
return extExpiresIn;
}

public void setExtExpiresIn(String extExpiresIn) {
this.extExpiresIn = extExpiresIn;
}

public String getExpiresOn() {
return expiresOn;
}

public void setExpiresOn(String expiresOn) {
this.expiresOn = expiresOn;
}

public String getNotBefore() {
return notBefore;
}

public void setNotBefore(String notBefore) {
this.notBefore = notBefore;
}

public String getResource() {
return resource;
}

public void setResource(String resource) {
this.resource = resource;
}

public String getAccessToken() {
return accessToken;
}

public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

}