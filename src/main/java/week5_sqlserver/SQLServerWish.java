package week5_sqlserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/wish")
public class SQLServerWish extends HttpServlet{

	   private Connection connection;
	   private Statement statement;
	   private ResultSet resultset;
	  
	   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		      resp.setContentType("text/html");
		      PrintWriter out = resp.getWriter();
		      try {
		    	  	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	  	connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=Wish; user=sa; password=123; encrypt=false;");
		    	  	statement = connection.createStatement();
					resultset = statement.executeQuery("select * from product");
					while ( resultset.next()) {
						int id=  resultset.getInt("id");
						String name = resultset.getString("name");
						
						out.println("<br>"+ id + ", " + name );
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
	   
}
	
