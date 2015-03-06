package com.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("employeeContext.xml");
		//EmployeeBean eb = new EmployeeBean("abcd");
		EmployeeBean eb =(EmployeeBean) ac.getBean("emp");
		System.out.println(eb.getEmpName());
	}

}
