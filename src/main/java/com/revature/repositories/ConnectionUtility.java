package com.revature.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://javafs200803.ciczslryb8mp.us-west-1.rds.amazonaws.com:5432/project0";
		String username = "postgres";
		String password = "password4";
		
		return DriverManager.getConnection(url, username, password);
		
	}

	//Tested connection
//	public static void main(String[] args) {
//		
//		try(Connection con = ConnectionUtility.getConnection()){
//			System.out.println("Connection successful!");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
}
