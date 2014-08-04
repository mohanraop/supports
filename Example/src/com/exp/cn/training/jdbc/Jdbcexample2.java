
package com.exp.cn.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcexample2 {
	
	 Connection con = null;
	 
	 Statement stmt= null;
	
	public static void main(String[] args) {
		Jdbcexample2 example = new Jdbcexample2();
		example.createConnection();
		example.insertStudent();
			
	}
	
	public void createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("1.Driver is loaded");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		 try {
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbeqp", "root", "root");
			   System.out.println("2.Connection established");
			} catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		 
	
	}
	
	
	
	public void insertStudent(){
		String insertString1, insertString2, insertString3;
		insertString1 = "insert into Student values('section1',30,15,15)";
		insertString2 = "insert into Student values('section2',40,20,20)";
		insertString3 = "insert into Student values('section3',50,25,25)";
		
		System.out.println("Stament created");
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(insertString1);
	   		stmt.executeUpdate(insertString2);
	   		stmt.executeUpdate(insertString3);
	   		
	   		System.out.println("4.execute statement");

			stmt.close();
			con.close();
			System.out.println("5.close connection");

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

	
	
}
