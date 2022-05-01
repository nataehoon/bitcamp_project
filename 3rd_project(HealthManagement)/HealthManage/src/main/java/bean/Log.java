package bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Log {
	private int logno;
	private String id;
	private String regdate;
	@NotEmpty(message="운동일지는 필수 입력 사항입니다.")
	private String loglist;
	private String comments;
	private String remark;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLogno() {
		return logno;
	}
	public void setLogno(int logno) {
		this.logno = logno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoglist() {
		return loglist;
	}
	public void setLoglist(String loglist) {
		this.loglist = loglist;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Log [logno=" + logno + ", id=" + id + ", regdate=" + regdate + ", loglist=" + loglist + ", comments="
				+ comments + ", remark=" + remark + ", image=" + image + "]";
	}
	
}
