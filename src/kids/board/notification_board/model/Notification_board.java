package kids.board.notification_board.model;

import java.util.Date;

public class Notification_board {
	private int dailyno ;
	private int  class_id ;
	private String pid ;
	private String contents ;
	private String image ;
	private String regdate ;
	private String checks ;
	private int send ;
	private String remark ;
	
	public Notification_board() {}

	public int getDailyno() {
		return dailyno;
	}

	public void setDailyno(int dailyno) {
		this.dailyno = dailyno;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

	public int getSend() {
		return send;
	}

	public void setSend(int send) {
		this.send = send;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Notification_board [dailyno=" + dailyno + ", class_id=" + class_id + ", pid=" + pid + ", contents="
				+ contents + ", image=" + image + ", regdate=" + regdate + ", checks=" + checks + ", send=" + send
				+ ", remark=" + remark + "]";
	}

	
	
	
	
}
