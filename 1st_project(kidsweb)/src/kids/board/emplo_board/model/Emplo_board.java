package kids.board.emplo_board.model;

public class Emplo_board {
	private int empno;
	private String tid;
	private String content;
	private String files;
	private String regdate;
	private String remark;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
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
	@Override
	public String toString() {
		return "Emplo_board [empno=" + empno + ", tid=" + tid + ", content=" + content + ", files=" + files
				+ ", regdate=" + regdate + ", remark=" + remark + "]";
	}
	
	
	
}
