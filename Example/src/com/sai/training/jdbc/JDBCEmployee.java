package com.sai.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBCEmployee {
	static Statement s;
	static Connection c;

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "JDBC Programming Example");
		int choice = -1;
		do {
			choice = getChoice();
			if (choice != 0) {
				Selected(choice);
			}
		} while (choice != 0);
		System.exit(0);

	}
	public static int getChoice() {
		String choice1;
		int ch;
		choice1 = JOptionPane.showInputDialog(null,
				"1. Create Employee Table\n"
						+ "2. Insert data into Employee Table\n"
						+ "3. Retrieve data for Employee Table\n"
						+ "0. Exit\n\n" + "Enter your choice");
		ch = Integer.parseInt(choice1);
		return ch;

	}
	public static void Selected(int choice) {
		if (choice == 1) {
			createEmployee();
		}
		if (choice == 2) {
			insertEmployee();
		}
		if (choice == 3) {
			retrieveEmployee();
		}
	}
	public static Connection getConnection(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Driver in get connection loaded");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/training", "root", "");
			System.out.println("2.Connection of get connection established");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return c;
	}
	
	public static void createEmployee()
	{
		Connection c1 = getConnection();
		String createString;
		createString = "create table Employee (" + "Emp_Name VARCHAR(30), "
				+ "EMP_ID INTEGER)";
		try {
			s = c1.createStatement();
			s.executeUpdate(createString);
			s.close();
			c1.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Employee Table Created");
		
	}
	
	public static void insertEmployee()
	{
		Connection c1= getConnection();
		String insertString;
		insertString = "insert into Employee values('Name',007)";
		try {
			s = c1.createStatement();
			for(int i=0;i<15;i++){
				s.executeUpdate("insert into Employee values('Name"+i+"',007)");
			}
			s.executeUpdate(insertString);
			s.close();
			c1.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,
				"Data Inserted into Employee Table");
			
	}
	public static void retrieveEmployee()
	{
		Connection c3 = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Employee";
		result = "Emp_Name\t\tEmp_ID\n";
		try {
			s = c3.createStatement();
			ResultSet rs = s.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("Emp_ID");
				String name = rs.getString("Emp_Name");
				result += id + "\t\t" + name + "\n";
			}
			s.close();
			c3.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, result);
	}

}
