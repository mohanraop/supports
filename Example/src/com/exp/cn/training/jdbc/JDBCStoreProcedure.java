package com.exp.cn.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCStoreProcedure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "amarpatlolla","amar01");
			System.out.println("connection established");
			CallableStatement stproc = con.prepareCall("{call INSERTDBUSER(?,?,?,?)}");
			stproc.setInt(1, 10);
			stproc.setString(2, "sandeep");
			stproc.setString(3, "mohan");
			stproc.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			stproc.execute();
			stproc.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
