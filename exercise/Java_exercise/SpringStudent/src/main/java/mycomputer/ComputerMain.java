package mycomputer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComputerMain {
	public static void main(String[] args) {
		String configLocation = "mycomputer/computer.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		Programmer soo = (Programmer)context.getBean("programmer");
		System.out.println(soo.toString());
	}
}
