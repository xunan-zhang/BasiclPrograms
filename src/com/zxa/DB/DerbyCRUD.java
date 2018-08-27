package com.zxa.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// start Derby by "C:\db-derby-10.14.2.0-bin\bin>startNetworkServer" on command line
public class DerbyCRUD {

	public static void main(String[] argv) {
		createDatabase();
		search();
		insert();
		search();
		update();
		search();
		delete();
		search();
		findByID(3);
		deleteAll();
		search();
	}
	
	public static void createDatabase() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//            String url = "jdbc:derby://localhost:1527/mydb;create=true";
            String url = "jdbc:derby://localhost:1527/mydb;";
            Connection conn = DriverManager.getConnection(url);

            Statement st = conn.createStatement();

            st.executeUpdate("CREATE TABLE Books(id INT PRIMARY KEY, book_title VARCHAR(30), author VARCHAR(30))");
            st.executeUpdate("INSERT INTO Books VALUES(1, 'Wuthering Heights', 'Emily Brontë')");
            st.executeUpdate("INSERT INTO Books VALUES(2, 'Middlemarch', 'George Eliot')");
            st.executeUpdate("INSERT INTO Books VALUES(3, 'Nineteen Eighty-Four', 'George Orwell')");
            st.executeUpdate("INSERT INTO Books VALUES(4, 'Jane Eyre', 'Charlotte Brontë')");
            st.executeUpdate("INSERT INTO Books VALUES(5, 'Great Expectations', 'Charles Dickens')");
            st.executeUpdate("INSERT INTO Books VALUES(6, 'Rebecca', ' Daphne du Maurier')");
            st.executeUpdate("INSERT INTO Books VALUES(7, 'Pride and Prejudice', 'Jane Austen')");
            st.executeUpdate("INSERT INTO Books VALUES(8, 'Emma', 'Jane Austen')");
            st.executeUpdate("INSERT INTO Books VALUES(9, 'Sense and Sensibility', 'Jane Austen')");

        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
        }
    }
	
	public static Statement getStatement() {

        String url = "jdbc:derby://localhost/mydb;";
		
        try {
    		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
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
			ResultSet rs = st.executeQuery("SELECT * FROM Books");

	        while (rs.next()) {
	            System.out.print(rs.getInt(1));
	            System.out.print(", ");
	            System.out.print(rs.getString(2));
	            System.out.print(", ");
	            System.out.println(rs.getString(3));
	        }
		} catch (Exception e) {
		}	
        System.out.println("");
	}

	public static Integer insert() {
		Statement st = getStatement();
        ResultSet rs = null;
        int record = 0;
        String sql = "INSERT INTO Books (id, book_title, author) VALUES (10, 'book 10', 'author 10')";
		
        try {
        	record = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return record;

	}

	public static void update() {
		Statement st = getStatement();
        ResultSet rs = null;
        String sql = "UPDATE Books SET book_title = 'Book updated', author = 'author updated'  where id=10";

        try {
        	st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete() {
		Statement st = getStatement();
        ResultSet rs = null;
        String sql = "DELETE FROM Books where id=10";

        try {
        	st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void findByID(Integer id) {
		Statement st = getStatement();
        String sql = "SELECT * FROM Books where id="+id;
        
		try {
			ResultSet rs = st.executeQuery(sql);

	        while (rs.next()) {
	            System.out.print(rs.getInt(1));
	            System.out.print(", ");
	            System.out.print(rs.getString(2));
	            System.out.print(", ");
	            System.out.println(rs.getString(3));
	        }
		} catch (Exception e) {
		}	
        System.out.println("");
	}
	
	public static void deleteAll() {
		Statement st = getStatement();
        ResultSet rs = null;
        String sql = "DROP TABLE Books";

        try {
        	st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
