package support.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {
	
	static Connection connect = null;
	 
	 Statement stmt1= null;
	
	 public static Connection createConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");	
				System.out.println("1.Driver in get connection loaded");
			} catch(java.lang.ClassNotFoundException e) {
				System.err.print("com.mysql.jdbc.Driver");
				System.err.println(e.getMessage());
			}
			
			 try {
				  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbeqp", "root", "root");
				   System.out.println("2.Connection of get connection established");
				} catch(SQLException ex) {
					System.err.println("SQLException: " + ex.getMessage());
				}

			return connect;
		}
	
	
	
	public void Section(){
		Connection connect= createConnection();
		String insertString1, insertString2, insertString3;
		insertString1 = "insert into Section values('s7',30,15,15)";
		insertString2 = "insert into Section values('s8',40,20,20)";
		insertString3 = "insert into Section values('s9',50,25,25)";
		System.out.println("Stament created");
		try {
			stmt1 = connect.createStatement();
	   		stmt1.executeUpdate(insertString1);
	   		stmt1.executeUpdate(insertString2);
	   		stmt1.executeUpdate(insertString3);
	   		
	   		System.out.println("4.execute statement");

			stmt1.close();
			connect.close();
			System.out.println("5.close connection");

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	public static void main(String[] args) {
		JDBCExample1 example = new JDBCExample1();
		//example.createConnection();
		example.Section();
	
}
}
