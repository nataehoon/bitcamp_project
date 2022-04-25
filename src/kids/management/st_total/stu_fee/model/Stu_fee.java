package kids.management.st_total.stu_fee.model;

public class Stu_fee {
		
	private int payno ;
	private int sid ;
	private String month ;
	private int unpaid ;
	private String remark ;
	
	public Stu_fee() {}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	@Override
	public String toString() {
		return "Stu_fee [payno=" + payno + ", sid=" + sid + ", month=" + month + ", unpaid=" + unpaid + ", remark="
				+ remark + "]";
	}

	

}
