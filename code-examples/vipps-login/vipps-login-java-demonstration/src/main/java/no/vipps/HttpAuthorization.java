package no.vipps;

import java.net.HttpURLConnection;

public interface HttpAuthorization {
    void authorize(HttpURLConnection connection);
}
