package com.sai.training;

public class Main {

	public static void main(String[] args)
	{
		Employee e=new Employee();
		Student s=new Student();
		s.firstName="sai";
		s.lastName="ram";
		s.fullName();
		e.empName="Sairam";	
		e.setEmpId(21);
		System.out.println(e.getEmpName());
		System.out.println(e.getEmpId());
		
	}

}
