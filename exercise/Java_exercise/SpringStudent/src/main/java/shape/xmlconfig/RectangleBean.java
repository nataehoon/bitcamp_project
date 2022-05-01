package shape.xmlconfig;

public class RectangleBean {
	private double width;
	private double height;
	
	public RectangleBean(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		String imsi = "";
		imsi += "밑변 : " + width + "\n";
		imsi += "높이 : " + height + "\n";
		imsi += "면적 : " + (width * height) + "\n";
		return imsi;
	}
	
}
