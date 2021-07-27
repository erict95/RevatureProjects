package facilities.Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static String url = "jdbc:postgresql://pocketmon.c628r9ldjbez.us-east-2.rds.amazonaws.com/Project_0";
	public static String username = "pmonster";
	public static String password = "p4ssw0rd";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
