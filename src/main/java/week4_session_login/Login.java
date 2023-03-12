package week4_session_login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import week4_session_login.context.DAO;
import week4_session_login.model.Admin;
@WebServlet(urlPatterns = "/web_login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("./week4_session/login.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u = req.getParameter("user");
		String p = req.getParameter("password");
		DAO d = new DAO();
		Admin a = d.check(u, p);
		HttpSession session = req.getSession();
		if(a == null) {
//			chưa có tài khoản
			req.setAttribute("error","tài khoản không tồn tại");
			req.getRequestDispatcher("./week4_session/login.jsp").forward(req, resp);
		}
		else {
//			có tài khoản
			session.setAttribute("account", a);
			req.getRequestDispatcher("./week4_session/wecomle.jsp").forward(req, resp);
		}
	}
}
