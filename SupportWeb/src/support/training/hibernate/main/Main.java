package support.training.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import support.training.hibernate.bean.Student1;
import support.training.hibernate.bean.Worker;


public class Main {
	
	public static void main(String[] args) {
		
		try{
			SessionFactory sessionFactory = new Configuration().configure(
			"/hibernate.cfg.xml")
			.buildSessionFactory();
			Session session =  sessionFactory.getCurrentSession();
			
			Transaction transaction =  session.beginTransaction();
			
			Worker worker  = new Worker();
			worker.setFirst_name("raju");
			worker.setLast_name("rao");
			worker.setSalary(12345);
			session.save(worker);
			
			Student1 student1 = new Student1();
			student1.setSt_name("hari");
			student1.setSt_class("PUC");
			student1.setSt_sub1("Maths");
			session.save(student1);
			
			session.saveOrUpdate(student1);
			
			session.update(student1);
			
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
