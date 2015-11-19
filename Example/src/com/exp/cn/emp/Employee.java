package com.exp.cn.emp;
public class Employee {

	String fName;
	String lName;
	int ID;	
	int priority;

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setfName(String FN) {
		this.fName = FN;
	}

	public String getfName() {
		return this.fName;

	}

	public void setlName(String LN) {
		this.lName = LN;
	}

	public String getlName() {
		return this.lName;
	}
	
	@Override
	public String toString() {
		return this.fName+"-"+this.priority;
	}
}
