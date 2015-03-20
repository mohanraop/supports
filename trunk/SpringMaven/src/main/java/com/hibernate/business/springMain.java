package com.hibernate.business;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.dao.SpringDao;
import com.hibernate.pojo.Employee;

public class springMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("hibernateContext.xml");
		SpringDao  sd=(SpringDao)ac.getBean("springDao");
		for(int i=100;i<200;i++){
		Employee e = new Employee();
		e.setEmpName("abcd"+i);	
		sd.saveObj(e);
		}
		
		
		List<Employee> employee1= sd.getEmplById(10);
		System.out.println(employee1.get(0).getEmpName());
		List<Employee> employees=sd.getEmployee();
		
		for(Employee emp:employees){
			System.out.println(emp.getEmpId()+"-----"+emp.getEmpName());
		}
		//Student st = new Stuuden
	}
}
