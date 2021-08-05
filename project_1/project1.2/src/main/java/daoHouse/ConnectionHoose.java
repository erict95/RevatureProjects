package daoHouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHoose {
	static { //necessary to make JDBC work in a WAR project
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
    }
	
	public static String url = "jdbc:postgresql://""/Project_1";
	public static String username = "";
	public static String password = "";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
