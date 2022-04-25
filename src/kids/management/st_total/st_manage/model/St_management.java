package kids.management.st_total.st_manage.model;

import java.util.Date;

public class St_management {
	
	private int stno ;
	private int sid ;
	private int poop ;
	private String healthy ;
	private int medicine_id ;
	private String attendance ;
	private String regdate ;
	private String sleep ;
	private String condition ;
	private String meal ;
	private String height ;
	private String weight ;
	private String remark ;
	
	public St_management() {}

	public int getStno() {
		return stno;
	}

	public void setStno(int stno) {
		this.stno = stno;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPoop() {
		return poop;
	}

	public void setPoop(int poop) {
		this.poop = poop;
	}

	public String getHealthy() {
		return healthy;
	}

	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
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

	public String getSleep() {
		return sleep;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "St_management [stno=" + stno + ", sid=" + sid + ", poop=" + poop + ", healthy=" + healthy
				+ ", medicine_id=" + medicine_id + ", attendance=" + attendance + ", regdate=" + regdate + ", sleep="
				+ sleep + ", condition=" + condition + ", meal=" + meal + ", height=" + height + ", weight=" + weight
				+ ", remark=" + remark + "]";
	}
	
	

}
