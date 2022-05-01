package shape.annotation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeMain {
	public static void main(String[] args) {
		String configLocation = "shape/annotation/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		Shape shape1 = context.getBean("myCircle", Shape.class);
		Object data1 = shape1.GetShapeOne();
		System.out.println("원의 정보");
		System.out.println(data1.toString());
		
		List<Object> list1 = shape1.GetAllShapes();
		System.out.println("원의 목록 보기");
		for(Object obj : list1) {
			System.out.println(obj);
		}
		
		Shape shape2 = context.getBean("myRectangle", Shape.class);
		Object data2 = shape1.GetShapeOne();
		System.out.println("사각형의 정보");
		System.out.println(data2.toString());
		
		List<Object> list2 = shape2.GetAllShapes();
		System.out.println("사각형들의 정보");
		for(Object ob : list2) {
			System.out.println(ob);
		}
	}
}
