package no.vipps;

import no.vipps.util.BearerToken;
import org.jsonbuddy.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class UserSession {

    private List<IdProviderSession> idProviderSessions = new ArrayList<>();

    public List<IdProviderSession> getIdProviderSessions() {
        return idProviderSessions;
    }

    public static UserSession getFromSession(HttpServletRequest req) {
        UserSession session = (UserSession) req.getSession().getAttribute(UserSession.class.getName());
        if (session == null) {
            req.getSession().invalidate();
            session = new UserSession();
            req.getSession(true).setAttribute(UserSession.class.getName(), session);
        }
        return session;
    }

    public void addSession(IdProviderSession session) {
        idProviderSessions.add(session);
    }

    public void removeSession(String servletPath) {
        idProviderSessions.removeIf(idProviderSession -> idProviderSession.getControlUrl().equals(servletPath));
    }

    public interface IdProviderSession {

        String getControlUrl();

        String getIssuer();

        String getAccessToken();

        void setAccessToken(String accessToken);

        String getRefreshToken();

        JsonObject getUserinfo();
    }

    public static class OpenIdConnectSession implements IdProviderSession {
        private String controlUrl;
        private String issuer;
        private BearerToken accessToken;
        private JsonObject userinfo;
        private Optional<String> refreshToken;
        private Optional<URL> endSessionEndpoint;

        public void setControlUrl(String controlUrl) {
            this.controlUrl = controlUrl;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public void setAccessToken(BearerToken accessToken) {
            this.accessToken = accessToken;
        }

        public void setUserinfo(JsonObject userinfo) {
            this.userinfo = userinfo;
        }

        public void setRefreshToken(Optional<String> refreshToken) {
            this.refreshToken = refreshToken;
        }

        public void setIdToken(JwtToken idToken) {
            this.idToken = idToken;
        }

        private JwtToken idToken;

        @Override
        public String getControlUrl() {
            return controlUrl;
        }

        @Override
        public String getIssuer() {
            return issuer;
        }

        @Override
        public JsonObject getUserinfo() {
            return userinfo;
        }

        @Override
        public String getRefreshToken() {
            return refreshToken.orElse(null);
        }

        public JwtToken getIdToken() {
            return idToken;
        }

        @Override
        public String getAccessToken() {
            return accessToken.toString();
        }

        @Override
        public void setAccessToken(String accessToken) {
            this.accessToken = new BearerToken(accessToken);
        }

        public HttpAuthorization getAccessBearerToken() {
            return accessToken;
        }

        public String getEndSessionEndpoint() {
            return endSessionEndpoint.map(URL::toString).orElse(null);
        }

        public void setEndSessionEndpoint(Optional<URL> endSessionEndpoint) {
            this.endSessionEndpoint = endSessionEndpoint;
        }
    }

    public static class Oauth2ProviderSession implements IdProviderSession {
        private String controlUrl;
        private BearerToken accessToken;
        private String issuer;
        private JsonObject userinfo;

        @Override
        public String getControlUrl() {
            return controlUrl;
        }

        public void setControlUrl(String controlUrl) {
            this.controlUrl = controlUrl;
        }

        @Override
        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        @Override
        public String getRefreshToken() {
            return null;
        }

        @Override
        public String getAccessToken() {
            return accessToken.toString();
        }

        @Override
        public void setAccessToken(String accessToken) {
            this.accessToken = new BearerToken(accessToken);
        }

        @Override
        public JsonObject getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(JsonObject userinfo) {
            this.userinfo = userinfo;
        }
    }
}
