package kids.management.emp_manage.model;

public class Emp_Manage {
	private int emp_mno;
	private int regday;
	private String tid;
	private String attendance;
	private String regdate;
	private String remark;
	
	public int getRegday() {
		return regday;
	}
	public void setRegday(int regday) {
		this.regday = regday;
	}
	public int getEmp_mno() {
		return emp_mno;
	}
	public void setEmp_mno(int emp_mno) {
		this.emp_mno = emp_mno;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Emp_Manage() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp_Manage [emp_mno=" + emp_mno + ", regday=" + regday + ", tid=" + tid + ", attendance=" + attendance
				+ ", regdate=" + regdate + ", remark=" + remark + "]";
	}
	
}
