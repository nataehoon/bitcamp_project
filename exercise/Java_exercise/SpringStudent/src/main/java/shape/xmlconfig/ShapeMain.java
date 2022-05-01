package shape.xmlconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeMain {
	public static void main(String[] args) {
		String configLocation = "shape/xmlconfig/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		System.out.println(context);
		
		System.out.println("==========================================");
		Circle circle1 = (Circle)context.getBean("circle");
		System.out.println(circle1);
		
		Object mycircle = circle1.GetShapeOne();
		System.out.println(mycircle.toString());
		
		List<Object> mycirclelists = circle1.GetAllShapes();
		for(Object circle : mycirclelists) {
			System.out.println(circle);
		}
		
		System.out.println("==========================================");
		Rectangle rectangle1 = (Rectangle)context.getBean("rectangle");
		System.out.println(rectangle1);
		
		Object myrectangle = rectangle1.GetShapeOne();
		System.out.println(myrectangle.toString());
		
		List<Object> myrectanglelists = rectangle1.GetAllShapes();
		for(Object rectangle : myrectanglelists) {
			System.out.println(rectangle);
		}
	}
}
