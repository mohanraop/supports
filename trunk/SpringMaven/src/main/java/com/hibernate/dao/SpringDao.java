package com.hibernate.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hibernate.pojo.Employee;


public class SpringDao extends HibernateDaoSupport{
	
	

	
	public void saveObj(Object obj){
		HibernateTemplate ht=getHibernateTemplate();
		ht.save(obj);
	}
	
	public List<Employee> getEmplById(int eId)
	{
		HibernateTemplate ht=getHibernateTemplate();
		return (List<Employee>)ht.find("from Employee where empId="+eId);
	}
	
	public List<Employee> getEmployee(){
		HibernateTemplate ht=getHibernateTemplate();
		//return (List<Employee>)ht.loadAll(Employee.class);
		
		return (List<Employee>)ht.find("from Employee");
		
	}
	
	

}
