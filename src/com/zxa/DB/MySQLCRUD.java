package com.zxa.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCRUD {
	
	public static void main(String[] argv) {
		getMySQLConnection();
	}

	public static Connection getMySQLConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = "jdbc:mysql://" + 		// db type
					"localhost:" + 				// host name
					"3306/" + 					// port
					"loginuser?" + 				// db name
					"useSSL=false&" + 			// do not use ssl
					"user=root&" + 				// login
					"password=Zxa302059!"; 		// password

			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				System.out.println("MySQL Connection Successful!");
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}