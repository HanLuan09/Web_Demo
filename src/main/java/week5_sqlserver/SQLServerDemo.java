package week5_sqlserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/books")
public class SQLServerDemo extends HttpServlet{

	   private Connection connection;
	   private Statement statement;
	   private ResultSet resultset;
	  
	   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		   	req.getRequestDispatcher("AddBook.jsp").forward(req, resp);
			resp.setContentType("text/html");
		      PrintWriter out = resp.getWriter();
		      try {
		    	  	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	  	connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=jdbc_demo1; user=sa; password=123; encrypt=false;");
		    	  	statement = connection.createStatement();
					resultset = statement.executeQuery("select * from Book");
					while ( resultset.next()) {
						int bookcode =  resultset.getInt("bookcode");
						String title = resultset.getString("title");
						String author= resultset.getString("author");
						String category =  resultset.getString("category");
						int sold = resultset.getInt("sold");
						out.println("<br>"+ bookcode + ", " + title +", "+ author+", "+  category + ", "  +  sold);
					}
		      } 
		      catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } 
		      catch (SQLException e) {
		         e.printStackTrace();
		      }
		      finally {
			        try {
			            if (resultset != null) {
			                resultset.close();
			            }
			            if (statement != null) {
			                statement.close();
			            }
			            if (connection != null) {
			                connection.close();
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			  }
	   }
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   resp.setContentType("text/html");
		   connection = null;
		      try {
		    	  	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	  	connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=jdbc_demo1; user=sa; password=123; encrypt=false;");
					PreparedStatement st = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?)");
					st.setString(1, req.getParameter("title"));
					st.setString(2, req.getParameter("author"));
					st.setString(3, req.getParameter("category"));
					st.setInt(4,req.getParameter("sold") != "null" ? 1:0);
//					Execute the query
					st.executeUpdate();
//					close;
					st.close();
					connection.close();
					resp.sendRedirect("books");
		      } 
		      catch (Exception e) {
		         e.printStackTrace();
		     } 	      
	}
}
	