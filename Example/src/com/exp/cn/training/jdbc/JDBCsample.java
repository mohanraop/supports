package com.exp.cn.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBCsample {
	static Statement stmt;
	static Connection con;

	public static void main(String args[]) {

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
				"1. Create Projects1 Table\n"
						+ "2. Insert data into Projects1 Table\n"
						+ "3. Retrieve data for Projects1 Table\n"
						+ "0. Exit\n\n" + "Enter your choice");
		ch = Integer.parseInt(choice1);
		return ch;

	}

	public static void Selected(int choice) {
		if (choice == 1) {
			createProjects1();
		}
		if (choice == 2) {
			insertProjects1();
		}
		if (choice == 3) {
			retrieveProjects1();
		}
	}

	public static Connection getOrcleConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.Driver in get connection loaded");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "amarpatlolla",
					"amar01");
			System.out.println("2.Connection of get connection established");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}

	public static Connection getConnection() {
		//return getOrcleConnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Driver in get connection loaded");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sai", "root", "");
			System.out.println("2.Connection of get connection established");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
		
	}

	public static void createProjects1() {
		Connection con = getConnection();

		String createString;
		createString = "create table Projects1 (" + "P_ID INTEGER, "
				+ "Name VARCHAR(30))";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Projects1 Table Created");
	}

	public static void insertProjects1() {
		Connection con = getConnection();

		String insertString1, insertString2;
		insertString1 = "insert into Projects1 values(2656, 'Bhanu')";
		insertString2 = "insert into Projects1 values(5768, 'Bob')";

		try {
			stmt = con.createStatement();
			for(int i=0;i<20;i++){
				stmt.executeUpdate("insert into Projects1 values(2656, 'Bhanu"+i+"')");
			}
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,
				"Data Inserted into Projects1 Table");

	}

	public static void retrieveProjects1() {
		Connection con = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Projects1";
		result = "P_ID\t\tName\n";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("P_ID");
				String name = rs.getString("Name");
				result += id + "\t\t" + name + "\n";
			}
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, result);
	}
}
