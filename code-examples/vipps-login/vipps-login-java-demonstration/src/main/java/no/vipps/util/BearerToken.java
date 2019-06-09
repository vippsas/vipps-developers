package no.vipps.util;

import no.vipps.HttpAuthorization;

import java.net.HttpURLConnection;

public class BearerToken implements HttpAuthorization {
    private String value;

    public BearerToken(String bearerToken) {
        this.value = bearerToken;
    }

    @Override
    public void authorize(HttpURLConnection connection) {
        connection.setRequestProperty("Authorization", "Bearer " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
