package week4_session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/nhap1")
public class Session2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		List<String> list;
		HttpSession session = req.getSession();
		session.setAttribute("fa", "Hán Văn Luân");
		if(session.getAttribute("names") == null) {
			list = new ArrayList<>();
		}
		else {
			list = (List<String>)session.getAttribute("names");
		}
		list.add(name);
		session.setAttribute("names", list);
		req.getRequestDispatcher("/week4_session/nhap.jsp").forward(req, resp);
	}
}
