package week4_session_login.context;


import java.sql.*;

public class DBContext {
     public Connection getConnection()throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=test; user=sa; password=123; encrypt=false;");
    }   

    public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no");
		}
	}
    
}
 