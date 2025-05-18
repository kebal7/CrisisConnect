package com.crisisconnect.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * DbConfig is a utility class responsible for managing the database configuration 
 * and establishing a connection to the MySQL database used by the CrisisConnect application.
 *
 * It provides a single static method to obtain a Connection object by connecting 
 * to the specified database with the provided credentials.
 */

public class DbConfig {
	private static final String DB_NAME = "CrisisConnect";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	/**
	 * Establishes and returns a connection to the MySQL database using the specified
	 * URL, username, and password.
	 *
	 * @return a {@link Connection} object to the configured database.
	 * @throws SQLException if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
}
