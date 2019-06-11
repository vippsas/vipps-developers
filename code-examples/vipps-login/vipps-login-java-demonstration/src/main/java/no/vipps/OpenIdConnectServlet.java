package no.vipps;

import org.jsonbuddy.JsonObject;
import org.jsonbuddy.parse.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class OpenIdConnectServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(OpenIdConnectServlet.class);

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String grantType;

    private URL authorizationEndpoint;
    private URL tokenEndpoint;
    private URL userInfoEndpoint;
    private String scope;
    private OpenidConfiguration configuration;
    private Oauth2ClientConfiguration clientConfiguration;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            clientConfiguration = getOauth2ClientConfiguration("vipps");
            this.clientId = clientConfiguration.getClientId();
            this.clientSecret = clientConfiguration.getClientSecret();
            this.redirectUri = clientConfiguration.getRedirectUri();

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("Loading openid-configuration from {}", "https://apitest.vipps.no/access-management-1.0/access" + "/.well-known/openid-configuration");
        try {
            configuration = new OpenidConfiguration("https://apitest.vipps.no/access-management-1.0/access");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.authorizationEndpoint = configuration.getAuthorizationEndpoint();
        this.tokenEndpoint = configuration.getTokenEndpoint();
        this.userInfoEndpoint = configuration.getUserinfoEndpoint();
        this.scope = "openid name nnin birthDate email phoneNumber address";
        this.grantType = "authorization_code";
    }


    private Oauth2ClientConfiguration getOauth2ClientConfiguration(String providerName) throws IOException {
        Properties properties = new Properties();

        try (FileReader reader = new FileReader("src/vipps-login.properties")) {
            properties.load(reader);
        }

        Oauth2ClientConfiguration configuration = new Oauth2ClientConfiguration(providerName);
        configuration.setClientId(properties.getProperty(providerName + ".client_id"));
        configuration.setClientSecret(properties.getProperty(providerName + ".client_secret"));
        configuration.setRedirectUri(properties.getProperty(providerName + ".redirect_uri"));
        return configuration;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] pathParts;
        if(req.getPathInfo() != null){
            pathParts = req.getPathInfo().split("/");
        }else{
            pathParts = req.getServletPath().split("/");
        }


        if (pathParts.length < 2) {
            resp.sendError(404);
            return;
        }

        try (MDC.MDCCloseable ignored = MDC.putCloseable("provider", req.getServletPath())) {
            String action = pathParts[1];
            if (action.equals("authenticate")) {
                authenticate(req, resp);
            } else if (action.equals("callback")) {
                oauth2callback(req, resp);
            } else if (action.equals("token")) {
                getToken(req, resp);
            } else if (action.equals("session")) {
                setupSession(req, resp);
            }else if (action.equals("logout")) {
                logoutSession(req, resp);
            } else {
                logger.warn("Unknown request {}", req.getServletPath() + req.getPathInfo() + "?" + req.getQueryString());
                resp.sendError(404);
            }
        }
    }

    private void authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginState = UUID.randomUUID().toString();
        req.getSession().setAttribute("loginState", loginState);

        String domainHint = req.getParameter("domain_hint");

        URL authenticationRequest = new URL(authorizationEndpoint + "?"
                + "client_id=" + clientId + "&"
                + "redirect_uri=" + redirectUri + "&"
                + "response_type=" + "code" + "&"
                + "scope=" + scope + "&"
                + "state=" + loginState
                + (domainHint != null ? "&domain_hint=" + domainHint : "")
        );

        logger.debug("Generating authentication request: {}", authenticationRequest);

        resp.setContentType("text/html");

        resp.getWriter().write("<!DOCTYPE html>\n"
                        + "<html>"
                        + "<head>"
                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                        + "</head>"
                        + "<body>"
                        + "<h2>Step 1: Redirect to authorization endpoint</h2>"
                        + "<div><a href='" + authenticationRequest + "'>Authenticate at " + authorizationEndpoint + "</a></div>"
                        + "<div>"
                        + "Normally your app would redirect directly to the following URL: <br />"
                        + "<code>"
                        + authenticationRequest.toString().replaceAll("[?&]", "<br />&nbsp;&nbsp;&nbsp;&nbsp;$0")
                        + "</code>"
                        + "</div></body></html>");
    }

    private void oauth2callback(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        String state = req.getParameter("state");
        String token = DatatypeConverter.printBase64Binary((clientId + ":" + clientSecret).getBytes("UTF-8"));

        logger.debug("oauth2callback code {}", code);
        logger.debug("oauth2callback with response {}: {}", Collections.list(req.getParameterNames()), req.getQueryString());

        String loginState = (String) req.getSession().getAttribute("loginState");
        if (loginState == null) {
            logger.warn("Callback received without having called authorize first!");
        } else if (loginState.equals(state)) {
            logger.debug("Login state matches callback state: {}", state);
        } else {
            logger.warn("Login state DOES NOT match callback state: {} != {}", loginState, state);
        }

        String error = req.getParameter("error");
        if (error != null) {
            resp.setContentType("text/html");

            String errorDescription = req.getParameter("error_description");

            resp.getWriter().write("<!DOCTYPE html>\n"
                    + "<html>"
                    + "<head>"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "</head>"
                    + "<body>"
                    + "<h2>Step 2b: Client received callback with error!</h2>"
                    + "<div>Error: <code>" + error + "</code></div>"
                    + (errorDescription != null ? "<div>Error description: <code>" + errorDescription + "</code></div>" : "")
                    + "<div><a href='/'>Front page</a></div>"
                    + "</body>"
                    + "</html>");
            return;
        }

        String header = "&nbsp;&nbsp;&nbsp;&nbsp;Authorization: Basic " + token + "<br />&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "Content-Type: application/x-www-form-urlencoded";

        String payload =
                "redirect_uri=" + redirectUri
                + "&" + "code=" + code
                + "&" + "grant_type=" + grantType;



        resp.setContentType("text/html");


        resp.getWriter().write("<!DOCTYPE html>\n"
                + "<html>"
                + "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "</head>"
                + "<body>"
                + "<h2>Step 2: Client received callback with code</h2>"
                + "<div>Recieved query parameters in callback from Vipps Login: </br>"
                + "<pre>" + req.getQueryString() + "</pre>"
                + "<p>We need code from query parameters to request access_token."
                + "<div><a href='" + req.getServletPath() + "/token?" + payload + "'>Fetch token with POST to " + tokenEndpoint + "</a></div>"
                + "<div>"
                + "Normally your app would directly perform a POST to <code>" + tokenEndpoint
                + "</br>"
                + "header:<br />"
                + "<code>"
                + header
                + "</code>"
                + "</br>"
                +" payload:<br />"
                + "<code>&nbsp;&nbsp;&nbsp;&nbsp;"
                + payload.replaceAll("[?&]", "<br />&nbsp;&nbsp;&nbsp;&nbsp;$0")
                + "</code>"
                + "<p>The Basic Authorization token is created by Base64 encoding client_id and client_secret like this </br><code>String token = DatatypeConverter.printBase64Binary((client_id + \":\" + client_secret).getBytes(\"UTF-8\"));</code><p>"
                + "</div></body></html>");
    }

    private void getToken(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String payload = req.getQueryString();
        String token = DatatypeConverter.printBase64Binary((clientId + ":" + clientSecret).getBytes("UTF-8"));

        Integer endOfReplace = payload.indexOf("redir");

        payload = payload.substring(endOfReplace);

        logger.debug("Fetching token from POST {} with payload: {}", tokenEndpoint, payload);

        HttpURLConnection connection = (HttpURLConnection) tokenEndpoint.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + token);
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

        connection.setDoOutput(true);
        connection.setDoInput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(payload.getBytes());
        }

        String response;
        if (connection.getResponseCode() < 400) {
            response = toString(connection.getInputStream());
        } else {
            response = toString(connection.getErrorStream());
        }

        logger.debug("Token response: {}", response);
        req.getSession().setAttribute("token_response", response);
        resp.setContentType("text/html");

        resp.getWriter().write("<!DOCTYPE html>\n"
                + "<html>"
                + "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "</head>"
                + "<body>"
                + "<h2>Step 3: Process token</h2>"
                + "<div>Response from " + tokenEndpoint
                + "</br> The access_token is what we got in exchange for code.</div>"
                + "<pre>" + response + "</pre>"
                + (connection.getResponseCode() < 400
                ? "<a href='" + req.getServletPath() + "/session'>Fetch userinfo from " + configuration.getUserinfoEndpoint() + " and create session</a>"
                + "<div>Normally your app/server will directly perform a request to " + configuration.getUserinfoEndpoint() +"</div>"
                + "header:<br />"
                + "<code>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;Autorization: Bearer " + JsonParser.parseToObject(response).requiredString("access_token")
                + "</code>"
                + "</br>"
                : "")
                + "</body></html>");

    }

    private void setupSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JsonObject tokenResponse = JsonParser.parseToObject((String) req.getSession().getAttribute("token_response"));
        logger.debug("Access token: {} expires {}",
                tokenResponse.requiredString("access_token"),
                tokenResponse.stringValue("expires_on").orElse(""));


        UserSession.OpenIdConnectSession session = new UserSession.OpenIdConnectSession();
        session.setControlUrl(req.getServletPath());
        session.setAccessToken(tokenResponse.requiredString("access_token"));
        session.setRefreshToken(tokenResponse.stringValue("refresh_token"));

        session.setEndSessionEndpoint(configuration.getEndSessionEndpoint());

        session.setUserinfo(jsonParserParseToObject(configuration.getUserinfoEndpoint(), session.getAccessBearerToken()));

        UserSession.getFromSession(req).addSession(session);
        resp.sendRedirect("/");
    }

    private void logoutSession(HttpServletRequest req, HttpServletResponse resp) {
        logger.debug("Logging out session {}", req.getQueryString());

        UserSession.getFromSession(req).removeSession(req.getServletPath());

        resp.setStatus(200);
    }


    private JsonObject jsonParserParseToObject(URL endpoint, HttpAuthorization authorization) throws IOException {
        logger.debug("Fetching from {}", endpoint);
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        authorization.authorize(connection);
        JsonObject response = JsonParser.parseToObject(connection);
        logger.debug("Response: {}", response);
        return response;
    }

    private String toString(InputStream inputStream) throws IOException {
        StringBuilder responseBuffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int c;
            while ((c = reader.read()) != -1) {
                responseBuffer.append((char) c);
            }
        }
        return responseBuffer.toString();
    }
}
