package com.sai.training.core;

public class Student 
{
	String firstName;
	String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void fullName()
	{
		System.out.println("Full name is: " +firstName+ " " +lastName);
    System.out.println("Full name is: " +firstName+ " " +lastName);  
	}
}
