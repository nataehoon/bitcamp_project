package kids.management.reservation.model;

public class Reservation {
	private int rid ;
	private String tid ;
	private String textarea ;
	private String status ; 
	private String res_date ;
	private String reg_date ;
	private String name ;
	private String hp ;
	private String remark ;
	private String tname;
	
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Reservation() {}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Reservation [rid=" + rid + ", tid=" + tid + ", textarea=" + textarea + ", status=" + status
				+ ", res_date=" + res_date + ", reg_date=" + reg_date + ", name=" + name + ", hp=" + hp + ", remark="
				+ remark + "]";
	}
	
	
	

}
