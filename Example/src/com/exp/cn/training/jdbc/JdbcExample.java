package com.exp.cn.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amarpatlolla","amar01");
			System.out.println("connection established");
			
			Statement stm=con.createStatement();
			String sql="select * from ADADMINISTRATIONDOMAIN";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getInt("MSCHEMAVERSIONNUMBER"));
				System.out.println(rs.getString("MNAME"));
				System.out.println(rs.getInt("LASTCOMMITNUMBER"));
			}
			
			Statement stmt=con.createStatement();
			String insertString1, insertString2;
			insertString1 = "insert into Projects1 values(2656, 'Bhanu')";
			insertString2 = "insert into Projects1 values(5768, 'Bob')";

			stmt = con.createStatement();
			for(int i=0;i<20;i++){
				stmt.executeUpdate("insert into Projects1 values(2656, 'Bhanu"+i+"')");
			}
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);
			
			PreparedStatement  ps = con.prepareStatement("insert into PROJECTS1 values(?,?)");
			for( int i=0;i<200000;i++){
				ps.setInt(1, i);
				ps.setString(2, "ABC"+i);
				ps.addBatch();
				if(i%1000==0){
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
