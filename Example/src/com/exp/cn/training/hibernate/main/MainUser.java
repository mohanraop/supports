package com.exp.cn.training.hibernate.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.exp.cn.training.hibernate.bean.User;




public class MainUser {
	public static void main(String[] args) {
		
			
			try{
				SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
				Session session =  sessionFactory.getCurrentSession();
				
				Transaction transaction =  session.beginTransaction();
				
				
				User user = new User();
				user.setPlace("GUN");
				
				session.saveOrUpdate(user);
				
							
				transaction.commit();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}

