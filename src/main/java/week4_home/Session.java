package week4_home;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet (urlPatterns = "/send-session")
public class Session extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 	HttpSession session = req.getSession();
	     	String sessionId = session.getId();
	     	PrintWriter out = resp.getWriter();
	     	out.println("Session ID: " + sessionId);
	}
}
