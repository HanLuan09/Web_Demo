package week4_session_login.context;

import week4_session_login.model.Admin;
import java.sql.*;
public class DAO extends DBContext{
	public Admin check(String name, String password) {
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT [name]\r\n"
				+ "      ,[password]\r\n"
				+ "      ,[role]\r\n"
				+ "  FROM [dbo].[Admin]\r\n"
				+ "  where name = ? and password = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, password);
			rs= st.executeQuery();
			if(rs.next()) {
				Admin a = new Admin(rs.getString("name"), rs.getString("password"), rs.getInt("role"));
				return a;
			}
		}
		catch (Exception e) {
		}
		return null;
		
	}
}
