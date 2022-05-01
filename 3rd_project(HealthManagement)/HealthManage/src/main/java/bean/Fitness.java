package bean;

public class Fitness {
	private int fitno;
	private String name;
	private String address;
	private String xaxis;
	private String yaxis;
	private String remark;
	private String gu;
	

	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public int getFitno() {
		return fitno;
	}
	public void setFitno(int fitno) {
		this.fitno = fitno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getXaxis() {
		return xaxis;
	}
	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}
	public String getYaxis() {
		return yaxis;
	}
	public void setYaxis(String yaxis) {
		this.yaxis = yaxis;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Fitness [fitno=" + fitno + ", name=" + name + ", address=" + address + ", xaxis=" + xaxis + ", yaxis="
				+ yaxis + ", remark=" + remark + "]";
	}
	
	
}
