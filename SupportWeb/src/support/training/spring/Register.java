package support.training.spring;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Register {
	
	@Resource(name="student")
	Student student;
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("/applicationTraining.xml");
		Student s1= (Student) context.getBean("student");
		s1.setSname("madhu");
		s1.setSno(37);
		s1.result();
	}

}
