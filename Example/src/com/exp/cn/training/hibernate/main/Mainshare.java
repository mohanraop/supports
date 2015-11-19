package com.exp.cn.training.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.exp.cn.training.hibernate.bean.Shares;


public class Mainshare {
	public static void main(String[] args) {
		
		
		try{
			SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
			Session session =  sessionFactory.getCurrentSession();
			
			Transaction transaction =  session.beginTransaction();
			
			 Shares shares = new Shares();
			 shares = null;
			 
			 session.createSQLQuery("delete from shares where s_quantity=4");
			
			 //session.
			 
			
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
