package week5_mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/web_books")
public class MySQLDemo extends HttpServlet{
	String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	String username = "root";
	String password = "Luan1001";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.getRequestDispatcher("BookAdd.jsp").forward(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			resultset =statement.executeQuery("select * from Book");
			while ( resultset.next()) {
				int bookcode =  resultset.getInt("bookcode");
				String title = resultset.getString("title");
				String author= resultset.getString("author");
				String category =  resultset.getString("category");
				int sold = resultset.getInt("sold");
				out.println("<br>"+ bookcode + ", " + title +", "+ author+", "+  category + ", "  +  sold);
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	   @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			   resp.setContentType("text/html");
			   Connection connection = null;
			      try {
			    	  	Class.forName("com.mysql.cj.jdbc.Driver");
						connection = DriverManager.getConnection(url, username, password);
						PreparedStatement st = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?)");
						st.setString(1, req.getParameter("title"));
						st.setString(2, req.getParameter("author"));
						st.setString(3, req.getParameter("category"));
						st.setInt(4,req.getParameter("sold") != "null" ? 1:0);
//						Execute the query
						st.executeUpdate();
//						close;
						st.close();
						connection.close();
						resp.sendRedirect("web_books");
			      } 
			      catch (Exception e) {
			         e.printStackTrace();
			     } 	      
		}
}