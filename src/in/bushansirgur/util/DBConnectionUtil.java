package in.bushansirgur.util;

import java.sql.*;
import java.sql.Connection; // [Ctrl + Shift + O]
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	// Define the database properties	
	private static final String URL = "jdbc:mysql://localhost:3306/employeedirectory";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "mysql@7409491538";
	
	//Reference variable -> to hold the connection object
	private static Connection connection = null;  
	
	//Define the static method OR Get the database connection
	public static Connection openConnection() {
		
		// Check the connection
		if (connection != null)
			 return connection;
        else {
        	
        }
            try {
            	// Load the Driver
                Class.forName(DRIVER);
                
                // Get the Connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            
            // Return Connection
            return connection;
        }
	}
