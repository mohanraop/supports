package com.hibernate.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hibernate.pojo.Employee;

@Repository("springDao")
public class SpringDao extends HibernateDaoSupport{
	
	
	@Autowired
	SessionFactory sessionFactory;


	public HibernateTemplate createHibernateTemplate() {
		setSessionFactory(sessionFactory);
		return getHibernateTemplate();
	}

	
	public void saveEmployee(Employee emp){
		createHibernateTemplate().save(emp);
	}

}
