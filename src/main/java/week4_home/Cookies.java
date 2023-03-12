package week4_home;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet (urlPatterns = "/sends-session")
public class Cookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie[] cookies =req.getCookies();
        String sessionId = "";
        if (cookies != null) {
            for(Cookie c: cookies) {
                if (c.getName().equals("JSESSIONID")) {
                    sessionId = c.getValue();
//                    out.println("Session ID: " + c.getValue());
                    break;
                }
            }
        }
        out.println("Session ID: " + sessionId);
	}
}
