package com.sai.training.core;
import java.util.Calendar;


public class Employee implements LivelyThings
{
	String empName;
	int empId;
	int birthYear;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	@Override
	public String giveYourName() {
		// TODO Auto-generated method stub
		return empName;
	}
	@Override
	public int giveYourAge() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return (year-birthYear);
	}
	

}
