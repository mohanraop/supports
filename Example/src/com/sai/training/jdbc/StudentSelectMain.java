package com.sai.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSelectMain {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			String selectString;
			selectString="select * from Student";
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery(selectString);
			while(r.next())
			{
				String Sname=r.getString("Stud_Name");
				System.out.println(Sname);
				int i=r.getInt("Stud_ID");
				System.out.println(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
