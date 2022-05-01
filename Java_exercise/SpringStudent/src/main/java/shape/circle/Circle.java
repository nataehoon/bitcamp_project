package shape.circle;

public class Circle {
	private double radius;
	private Point point;
	
	public Circle(double radius, Point point) {
		this.radius = radius;
		this.point = point;
	}

	@Override
	public String toString() {
		double area = 3.14;
		
		return "==원의 정보== \n 반지름 : " + radius + "\n " + point + "\n " + "면적 : " + area;
	}
	
	
}
