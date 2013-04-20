package com.train.ws.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShareInfromation {

	Connection connect = null;

	Statement stmt = null;

	private void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Driver is loaded");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbeqp", "root", "root");
			System.out.println("2.Connection established");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

	public void insertShare(String shareName, int sharePrice) {
		createConnection();
		String s1;
		s1 = "insert into stock values(" + sharePrice + ",'" + shareName + "')";

		try {
			stmt = connect.createStatement();
			stmt.executeUpdate(s1);
			stmt.close();
			connect.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}
