package support.service;



//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository
public class Register {

	
	public static void main(String[] args) {
 // ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//		Student s1= (Student) context.getBean("s1");
		Student s1=new Student();
		s1.setSname("madhu");
		s1.setSno(37);
	}

}
