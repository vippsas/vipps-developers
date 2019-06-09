package no.vipps;

import org.jsonbuddy.pojo.JsonGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/javascript");
        resp.getWriter().write("displayUser(");
        JsonGenerator.generateUsingImplementationAsTemplate(UserSession.getFromSession(req)).toJson(resp.getWriter());
        resp.getWriter().write(")");
    }
}
