package com.exp.cn.utill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exp.cn.emp.Employee;

public class EmployeeSort {
	
	public static void main(String[] args) {
		
		List<Employee> empList=new ArrayList<Employee>();
		
		Employee employee = new Employee();
		employee.setPriority(10);
		employee.setfName("abc10");
		
		empList.add(employee);
		
		employee = new Employee();
		employee.setPriority(1);
		employee.setfName("abc1");
		
		empList.add(employee);
		
		employee = new Employee();
		employee.setPriority(20);
		employee.setfName("abc20");
		
		empList.add(employee);
		
		employee = new Employee();
		employee.setPriority(5);
		employee.setfName("abc5");
		
		empList.add(employee);
		
		employee = new Employee();
		employee.setPriority(100);
		employee.setfName("abc100");
		
		Employee employee1 = new Employee();
		employee1.setPriority(100);
		employee1.setfName("abc100");
		
		empList.add(employee);
		
		System.out.println(empList);
		
		Collections.sort(empList,new EmployeeComparator());
		
		System.out.println(empList);
		
		//System.out.println(employee);
	}

}
