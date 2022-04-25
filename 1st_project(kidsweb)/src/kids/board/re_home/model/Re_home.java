package kids.board.re_home.model;

import java.util.Date;

public class Re_home {
	
	private int hono ;
	private String pid ;
	private String tid ;
	private Date regdate ;
	private String method ;
	private String relationship ;
	private String hp ;
	private String emp ;
	private String checks ;
	private String remark ;
	private int sid;
	private String name;
	
	public Re_home() {}

	public int getHono() {
		return hono;
	}

	public void setHono(int hono) {
		this.hono = hono;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Re_home [hono=" + hono + ", pid=" + pid + ", tid=" + tid + ", regdate=" + regdate + ", method=" + method
				+ ", relationship=" + relationship + ", hp=" + hp + ", emp=" + emp + ", checks=" + checks + ", remark="
				+ remark + ", sid=" + sid + ", name=" + name + "]";
	}

}
