package support.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/applicationTraining.xml");

		System.out.println("Spring context initialized.");

		
		Studentset studentset = (Studentset)applicationContext.getBean("studentset");

		System.out.println("message='" + studentset.getName() + "'");
		
		Studentcon studentcon = (Studentcon)applicationContext.getBean("studentcon");
		System.out.println("message="+studentcon.getId()+ "");
		

	}

}
