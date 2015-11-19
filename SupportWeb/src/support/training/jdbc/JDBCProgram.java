package support.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBCProgram {

	static String userid = "scott", password = "tiger";
	static String url = "jdbc:odbc:bob";
	// String url= "jdbc:mySubprotocol:myDataSource"; ?
	static Statement stmt;
	static Connection con;
	static PreparedStatement pstmt;

	public static void main(String args[]){

	JOptionPane.showMessageDialog(null,"JDBC Programming showing Retrieval of Table Data");
		int choice = -1;

		do{
			choice = getChoice();
			if (choice != 0){
				getSelected(choice);
			}
		}
		while ( choice !=  0);
			System.exit(0);
	}

	public static int getChoice() {
		String choice;
		int ch;
		choice = JOptionPane.showInputDialog(null,
				"1. Create Employees Table\n" 
		       + "2. Create Orders Table\n"
						+ "3. Create Products Table\n"
						+ "4. Insert data into Employees Table\n"
						+ "5. Insert data into Orders Table\n"
						+ "6. Insert data into Products Table\n"
						+ "7. Retrieve data for Employees Table\n"
						+ "8.  Retrieve data for Orders Table\n"
						+"9. Retrieve data for Products Table\n"
						+"10. Update data for Employees Table\n"
						+"11. prepareUpdate data for Employees Table\n"
						+"12. prepareUpdate data for Orders Table\n"
						+ "0. Exit\n\n" + "Enter your choice");
		ch = Integer.parseInt(choice);
		return ch;

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

	public static void getSelected(int choice) {
		if (choice == 1) {
			createEmployees();
		}
		if (choice == 2) {
			createOrders();
		}
		if (choice == 3) {
			createProducts();
		}
		if (choice == 4) {
			insertEmployees();
		}
		if (choice == 5) {
			insertOrders();
		}
		if (choice == 6) {
			insertProducts();
		}
		if (choice == 7) {
			retrieveEmployees();
		}
		if (choice == 8) {
			retrieveOrders();
		}
		if (choice == 9) {
			retrieveProducts();
		}
		if (choice == 10) {
			updateEmployees();
		}
		if (choice == 11) {
			updateEmployeesPrepared();
		}
		if (choice == 12){
			updateOrdersPrepared();
		}
	}
	public static void updateEmployeesPrepared(){
		Connection con = getConnection();
// create prepared statement
		try {
	pstmt = con.prepareStatement("update Employees set name = ? where Employee_Id  = ?");
	pstmt.setString(1, "hemanthbob");	//Note index starts with 1
	pstmt.setInt(2, 2656);

	   		pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch(SQLException ex) {
		   System.err.println("SQLException: " + ex.getMessage());
		}
	JOptionPane.showMessageDialog(null,"Data Updated into Employees Table after prepared statement");
	}

	private static void updateEmployees() {
		Connection con = getConnection();

		String updateString1;
		updateString1 = "update Employees set name = 'hemanthbalaji' where Employee_id = 2656";

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(updateString1);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	JOptionPane.showMessageDialog(null,"Data Updated into Employees Table");
	}

	public static Connection getConnection() {
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

		return con;
	}

	/*
	 * CREATE TABLE Employees ( Employee_ID INTEGER, Name VARCHAR(30) );
	 */
	
	public static void createEmployees() {
		Connection con = getConnection();

		String createString;
		createString = "create table Employees (" + "Employee_ID INTEGER, "
				+ "Name VARCHAR(30))";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Employees Table Created");
	}

	/*
	 * CREATE TABLE Orders ( Prod_ID INTEGER, ProductName VARCHAR(20),
	 * Employee_ID INTEGER );
	 */

	public static void createOrders() {
		Connection con = getConnection();

		String createString;
		createString = "create table Orders (" + "Prod_ID INTEGER, "
				+ "ProductName VARCHAR(20), " + "Employee_ID INTEGER )";

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Orders Table Created");
	}
	public static void createProducts() {
		Connection con = getConnection();

		String createString;
		createString = "create table Products (" + "Product_ID INTEGER, "
				+ "Name VARCHAR(30))";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Products Table Created");
	}

	/*
	 * Employee_ID Name 6323 Hemanth 5768 Bob 1234 Shawn 5678 Michaels
	 */
	public static void insertEmployees() {
		Connection con = getConnection();

		String insertString1, insertString2, insertString3, insertString4;
		insertString1 = "insert into Employees values(2656, 'Bhanu')";
		insertString2 = "insert into Employees values(5768, 'Bob')";
		insertString3 = "insert into Employees values(1234, 'Shawn')";
		insertString4 = "insert into Employees values(5678, 'Michaels')";

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);
			stmt.executeUpdate(insertString3);
			stmt.executeUpdate(insertString4);

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Data Inserted into Employees Table");
	}
	/*
	 * Prod_ID ProductName Employee_ID 543 Belt 6323 432 Bottle 1234 876 Ring
	 * 5678
	 */
	public static void insertOrders() {
		Connection con = getConnection();

		String insertString1, insertString2, insertString3, insertString4;
		insertString1 = "insert into Orders values(543, 'Belt', 6323)";
		insertString2 = "insert into Orders values(432, 'Bottle', 1234)";
		insertString3 = "insert into Orders values(876, 'Ring', 5678)";
		insertString4 = "insert into Orders values(123, 'Flower', 5656)";

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);
			stmt.executeUpdate(insertString3);
			stmt.executeUpdate(insertString4);

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Data Inserted into Orders Table");
	}
	public static void insertProducts() {
		Connection con = getConnection();

		String insertString1, insertString2, insertString3, insertString4;
		insertString1 = "insert into Products values(6323, 'dove')";
		insertString2 = "insert into Products values(5768, 'olay')";
		insertString3 = "insert into Products values(1234, 'closeup')";
		insertString4 = "insert into Products values(5678, 'bag')";

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);
			stmt.executeUpdate(insertString3);
			stmt.executeUpdate(insertString4);

			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Data Inserted into Products Table");
	}

	public static void retrieveEmployees() {
		Connection con = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Employees";
		result = "Employee_ID\t\tName\n";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("Employee_ID");
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

	public static void retrieveOrders() {
		Connection con = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Orders";
		result = "Prod_ID\t\tProductName\t\tEmployee_ID\n";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int pr_id = rs.getInt("Prod_ID");
				String prodName = rs.getString("ProductName");
				int id = rs.getInt("Employee_ID");
				result += pr_id + "\t\t" + prodName + "\t\t" + id + "\n";
			}
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null, result);
	}
	private static void retrieveProducts() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String result = null;
		String selectString;
		selectString = "select * from Products";
		result = "Product_ID\t\tName\n";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				int id = rs.getInt("Product_ID");
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
	public static void updateOrdersPrepared(){

		int [] productIds = {543, 432, 876};
		String [] productNames = {"cds", "dvds", "Espresso"};
		int len = productNames.length;

		Connection con = getConnection();

		try {
	pstmt = con.prepareStatement("update Orders set ProductName = ? where Prod_Id  = ?");
			for(int i = 0; i < len; i++) {
				pstmt.setInt(2, productIds[i]);
				pstmt.setString(1, productNames[i]);
				pstmt.executeUpdate();
			}

			pstmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	JOptionPane.showMessageDialog(null,"Data Updated into Orders Table");
	}
}// End of class