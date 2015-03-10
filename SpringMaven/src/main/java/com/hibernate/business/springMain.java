package com.hibernate.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.dao.SpringDao;
import com.hibernate.pojo.Employee;

public class springMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = new Employee();
		e.setEmpName("abcd");
		
		
		SpringDao  sd=(SpringDao)ac.getBean("springDao");
		
		sd.saveEmployee(e);
	}
}
