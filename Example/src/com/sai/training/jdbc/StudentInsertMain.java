package com.sai.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsertMain {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			String insertString;
			insertString="insert into Student values('sai',21)";
			Statement s= c.createStatement();
			s.executeUpdate(insertString);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
