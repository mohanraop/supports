package support.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	
	 Connection con = null;
	 
	 Statement stmt= null;
	
	public static void main(String[] args) {
		JDBCExample example = new JDBCExample();
		example.createConnection();
		example.insertStudent();
		
		//example.retrieveEmployees();
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
	
	public void insertEmployee(){
		String insertString1, insertString2, insertString3, insertString4;
		insertString1 = "insert into Employees values(6323, 'Hemanth')";
		insertString2 = "insert into Employees values(5768, 'Bob')";
		insertString3 = "insert into Employees values(1234, 'Shawn')";
		insertString4 = "insert into Employees values(5678, 'Michaels')";
		System.out.println("Stament created");
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(insertString1);
	   		stmt.executeUpdate(insertString2);
	   		stmt.executeUpdate(insertString3);
	   		stmt.executeUpdate(insertString4);
	   		System.out.println("4.execute statement");

			stmt.close();
			con.close();
			System.out.println("5.close connection");

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	public void insertStudent(){
		String insertString1, insertString2, insertString3, insertString4;
		insertString1 = "insert into Student values(6323, 'Hemanth')";
		insertString2 = "insert into Student values(5768, 'Bob')";
		insertString3 = "insert into Student values(1234, 'Shawn')";
		insertString4 = "insert into Student values(5678, 'Michaels')";
		System.out.println("Stament created");
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(insertString1);
	   		stmt.executeUpdate(insertString2);
	   		stmt.executeUpdate(insertString3);
	   		stmt.executeUpdate(insertString4);
	   		System.out.println("4.execute statement");

			stmt.close();
			con.close();
			System.out.println("5.close connection");

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	

}
