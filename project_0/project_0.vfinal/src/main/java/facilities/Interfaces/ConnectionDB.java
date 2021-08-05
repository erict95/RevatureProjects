package facilities.Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static String url = "jdbc:postgresql://""/Project_0";
	public static String username = "";
	public static String password = "";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
