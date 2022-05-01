package shape.circle;

public class ShapeMain {
	public static void main(String[] args) {
		Point point = new Point();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		double radius = 10.0;
		
		Circle circle = new Circle(radius, point);
		System.out.println(circle.toString());
	}
}
