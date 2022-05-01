package shape.circle;

public class Point {
	private double xpos;
	private double ypos;
	
	public void setXpos(double d) {
		this.xpos = d;
	}
	public void setYpos(double d) {
		this.ypos = d;
	}
	@Override
	public String toString() {
		return "X좌표 : " + xpos + ", Y좌표 : " + ypos;
	}
	
	
}
