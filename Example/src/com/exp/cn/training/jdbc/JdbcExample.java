package com.exp.cn.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
