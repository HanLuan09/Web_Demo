package week4_cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet (urlPatterns = "/send-cookies")
public class CookiesSend extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("Xin chao");
		Cookie cookie = new Cookie("name", "Lap-trinh-Web");
		cookie.setMaxAge(5);
		resp.addCookie(cookie);
		Cookie cookie2 = new Cookie("age", "30");
		cookie2.setMaxAge(10);
		resp.addCookie(cookie2);
	}
	
}
