package org.nagarro.hibernate.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/assignment2?useSSL=false";
		String user = "root";
		String password = "root";
		// TODO Auto-generated method stub
		try {
			System.out.println("Connecting to db: "+ jdbcURL);
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("Connection successful");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
