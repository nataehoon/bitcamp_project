package shape.annotation;

public class CircleBean {
	private double xpos;
	private double ypos;
	private double radius;
	
	public CircleBean(double xpos, double ypos, double radius) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.radius = radius;
	}

	@Override
	public String toString() {
		String imsi = "";
		imsi += "원의 중심 : (" + xpos + ", " + ypos + ")\n";
		imsi += "반지름 : (" + radius + ")\n";
		imsi += "면적 : (" + (3.14 * radius * radius) + ")\n";
		return imsi;
	}
	
}
