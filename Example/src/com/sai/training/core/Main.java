package com.sai.training.core;

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
		e.setBirthYear(1992);
		System.out.println(e.getEmpName());
		System.out.println(e.getEmpId());
		//617040725		
		System.out.println(e.getEmpId());
	    System.out.println(e.giveYourAge());
	    System.out.println(e.giveYourName());

	    Employee e2= new Employee("xz", 124, 1987);
	}

}
