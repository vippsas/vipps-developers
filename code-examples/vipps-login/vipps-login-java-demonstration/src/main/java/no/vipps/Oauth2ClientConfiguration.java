package no.vipps;

public class Oauth2ClientConfiguration {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String providerName;

    public Oauth2ClientConfiguration(String providerName) {
        this.providerName = providerName;
    }

    public void setClientId(String clientId) {
        this.clientId = verifyNotNull("clientId", clientId);
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = verifyNotNull("clientSecret", clientSecret);
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = verifyNotNull("redirectUri", redirectUri);
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    private String verifyNotNull(String propertyName, String value) {
        if (value == null) {
            throw new IllegalArgumentException("Missing " + propertyName + " for provider " + providerName);
        }
        return value;
    }

}
