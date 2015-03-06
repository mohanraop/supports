package com.sai.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class CarMain 
{
	static Connection c;
	static Statement s;
	public static void main(String[] args) 
	{
		int choice=getChoice();
		Selected(choice);
		
	}
	public static int getChoice()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("1. Create table 2. Insert into table 3.View table");
		System.out.println("Enter your choice:");
		int i=sc.nextInt();
		return i;
	}
	public static void Selected(int choice)
	
	{
		if(choice==1)
		{
			createCar();
		}
		if(choice==2)
		{
			insertCar();
		}
		if(choice==3)
		{
			selectCar();
		}
	}
	
	public static Connection getConnection()
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		 c= DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return c;
	}
	
	public static void createCar()
	{
		Connection c=getConnection();
		String createString;
		createString="create table Cars(Car_ID INTEGER,Car_Model VARCHAR(15))";
		try {
			s= c.createStatement();
			s.executeUpdate(createString);
			s.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void insertCar()
	{
		Connection c=getConnection();
		String insertString;
		insertString="insert into Cars values(1,'Sedan')";
		try {
			Statement s= c.createStatement();
			s.executeUpdate(insertString);
			s.close();
			c.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void selectCar()
	{
		Connection c= getConnection();
		String selectString;
		selectString="Select * from Cars";
		try {
			Statement s=c.createStatement();
			ResultSet r= s.executeQuery(selectString);
			while(r.next())
			{
				int i=r.getInt("Car_ID");
				System.out.println(i);
				String str=r.getString("Car_Model");
				System.out.println(str);
			}
			s.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
