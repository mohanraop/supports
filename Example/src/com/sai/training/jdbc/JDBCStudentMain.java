package com.sai.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStudentMain {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			String createString;
			createString="create table Student(Stud_Name VARCHAR(30),Stud_ID INTEGER)";
			Statement st= c.createStatement();
			st.executeUpdate(createString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
