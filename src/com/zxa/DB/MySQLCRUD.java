package com.zxa.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCRUD {
	
	public static void main(String[] argv) {
//		getMySQLConnection();
		search();
	}

	public static Connection getMySQLConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = "jdbc:mysql://" + 		// db type
					"localhost:" + 				// host name
					"3306/" + 					// port
					"mydb?" + 				// db name
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

	public static Statement getStatement() {

        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&user=root&password=Zxa302059!";
		
        try {
        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

    		return st;
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return null;
	}

	public static void search() {
		Statement st = getStatement();
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM users");

	        while (rs.next()) {
	            System.out.print(rs.getInt(1));
	            System.out.print(", ");
	            System.out.print(rs.getString(2));
	            System.out.print(", ");
	            System.out.println(rs.getString(3));
	        }
	        
	        System.out.println("Complete!");
		} catch (Exception e) {
		}	
        System.out.println("");
	}

	
}