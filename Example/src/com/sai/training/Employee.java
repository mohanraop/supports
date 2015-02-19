package com.sai.training;

public class Employee implements LivelyThings
{
	String empName;
	int empId;
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
	@Override
	public String giveYourName() {
		// TODO Auto-generated method stub
		return empName;
	}
	@Override
	public int giveYourAge() {
		// TODO Auto-generated method stub
		return 35;
	}
	

}
