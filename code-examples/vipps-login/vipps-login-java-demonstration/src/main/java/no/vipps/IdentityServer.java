package no.vipps;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.logevents.extend.servlets.LogEventsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class IdentityServer {

    private static Logger logger = LoggerFactory.getLogger(IdentityServer.class);
    private Server server = new Server();

    public static void main(String[] args) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler((thread,e) -> logger.error("{} uncaught exception", thread, e));
        new IdentityServer().start();
    }

    private void start() throws Exception {
        setupServer();
        server.start();
        logger.warn("Started {}", server.getURI());
    }

    private void setupServer() throws IOException {
        server.addLifeCycleListener(Server.STOP_ON_FAILURE);
        server.addConnector(createConnector());
        server.setHandler(createWebAppContext());
    }

    private ServerConnector createConnector() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(Optional.ofNullable(System.getenv("HTTP_PLATFORM_PORT"))
                .map(Integer::parseInt)
                .orElse(8087));
        connector.setHost("localhost");
        return connector;
    }

    private WebAppContext createWebAppContext() throws IOException {
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setBaseResource(Resource.newClassPathResource("/webapp-identity"));
        webAppContext.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");

        addOpenIdConnectServlet(webAppContext, "/id/vipps/*", "vipps", "https://apitest.vipps.no/access-management-1.0/access");

        webAppContext.addServlet(new ServletHolder(new UserServlet()), "/user");

        webAppContext.addServlet(new ServletHolder(new OpenIdConnectServlet()), "/callback/*");

        webAppContext.addServlet(new ServletHolder(new LogEventsServlet()), "/logs/*");


        return webAppContext;
    }

    private void addOpenIdConnectServlet(WebAppContext webAppContext, String pathSpec, String providerName, String openIdIssuerUrl) throws IOException {
        OpenIdConnectServlet servlet = new OpenIdConnectServlet();
        webAppContext.addServlet(new ServletHolder(servlet), pathSpec);
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

}
