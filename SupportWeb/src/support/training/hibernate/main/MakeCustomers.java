package support.training.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import support.training.hibernate.bean.Customer;

public class MakeCustomers {
public static void main(String[] args){
	Customer sai= new Customer();
	sai.setName("sai");
	sai.setGender("M");
	sai.setDateOfBirth(new Date());
	
	Customer nag= new Customer();
	nag.setName("nag");
	nag.setGender("F");
	nag.setDateOfBirth(new Date());
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction trx= session.beginTransaction();
	session.save(sai);
	session.save(nag);
	trx.commit();
	session.close();
	sf.close();
}
}
