package com.exp.cn.utill;

import java.util.Comparator;

import com.exp.cn.emp.Employee;

public class EmployeeComparator implements Comparator<Employee>{
	
	//0 - emp1,emp2 are equal
	//1 - emp1 > emp2
	//-1- emp1 < emp2

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if(emp1!=null&emp2!=null){
			if(emp1.getPriority() == emp2.getPriority()){
				return 0;
			}else if(emp1.getPriority() > emp2.getPriority()){
				return 1;
			}else if(emp1.getPriority() < emp2.getPriority()){
				return -1;
			}
		}
		return 0;
	}

}
