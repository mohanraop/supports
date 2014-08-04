package com.exp.cn.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {
	Connection connect = null;
	 
	 Statement stmt1= null;
	
	public void createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("1.Driver is loaded");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		 try {
			   connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbeqp", "root", "root");
			   System.out.println("2.Connection established");
			} catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		 
	
	}
	
	
	
	public void Section(){
		String deletestring;
		deletestring = "delete from section where name='s1'";
		
		System.out.println("Stament created");
		try {
			stmt1 = connect.createStatement();
	   		stmt1.executeUpdate(deletestring);
	   		System.out.println("4.execute statement");
			stmt1.close();
			connect.close();
			System.out.println("5.close connection");

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	public static void main(String[] args) {
		JDBCDelete example = new JDBCDelete();
		example.createConnection();
		example.Section();
		}
}


