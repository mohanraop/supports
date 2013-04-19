package support.training.spring;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Register {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("/applicationTraining.xml");
		Student student= (Student) context.getBean("student");
		student.result();
		PList plist=(PList) context.getBean("plist");
		plist.values();
	}

}
