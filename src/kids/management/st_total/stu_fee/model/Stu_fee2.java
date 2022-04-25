package kids.management.st_total.stu_fee.model;

public class Stu_fee2 {
		// 번호 이름 반 납부 미납금 비고 날짜
	private int payno ;
	private String name ;
	private String class_name ;
	private String paid;
	private int unpaid ;
	private String remark ;
	private String month;
	
	public Stu_fee2() {}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public int getUnpaid() {
		return unpaid;
	}

	public void setUnpaid(int unpaid) {
		this.unpaid = unpaid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Stu_fee2 [payno=" + payno + ", name=" + name + ", class_name=" + class_name + ", paid=" + paid
				+ ", unpaid=" + unpaid + ", remark=" + remark + ", month=" + month + "]";
	}

	

	

}
