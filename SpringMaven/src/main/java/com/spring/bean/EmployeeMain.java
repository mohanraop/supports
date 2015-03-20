package com.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//EmployeeBean eb = new EmployeeBean("abcd");
		EmployeeBean eb =(EmployeeBean) ac.getBean("emp");
		System.out.println(eb.getEmpName());
		
		//EmployeeBean e = new EmployeeBean();
		//CompanyBean c = new CompanyBean(eb);
		
		//Exercise e1=new Exercise(5);
		Exercise e1= (Exercise) ac.getBean("exer");;
	}

}
