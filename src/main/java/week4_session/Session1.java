package week4_session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/home1")
public class Session1 extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("name", "Luan");
		HttpSession session = req.getSession();
		session.setAttribute("names", "Han van luan");
//		resp.sendRedirect("/week4_session/home.jsp");
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
