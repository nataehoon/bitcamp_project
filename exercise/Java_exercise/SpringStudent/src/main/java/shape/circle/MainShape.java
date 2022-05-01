package shape.circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShape {
	public static void main(String[] args) {
		String configLocation = "shape/circle/shape.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		Circle circle = (Circle)context.getBean("circle");
		
		System.out.println(circle);
	}
}
