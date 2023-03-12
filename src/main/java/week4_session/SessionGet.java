package week4_session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet (urlPatterns = "/get-session")
public class SessionGet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String name = "";
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("name");
		if(obj != null) {
			name = String.valueOf(obj);
		}
		else {
			resp.sendRedirect("/DemoServelet");
		}
		writer.println("Xin chao " + name);
	}
//	cook  luu web, luu sess id
//	sess luu server
}
