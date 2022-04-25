package kids.board.medicine.model;


public class Medicine {
	
	private int meno ;
	private String pid ;
	private String tid ;
	private String regdate ;
	private String category ;
	private String amount ;
	private int reps ;
	private String hour ;
	private String storagemethod ;
	private String textarea ;
	private String checks ;
	private String remark ;
	
	public Medicine() {}

	public int getMeno() {
		return meno;
	}

	public void setMeno(int meno) {
		this.meno = meno;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getStoragemethod() {
		return storagemethod;
	}

	public void setStoragemethod(String storagemethod) {
		this.storagemethod = storagemethod;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
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

	@Override
	public String toString() {
		return "Medicine [meno=" + meno + ", pid=" + pid + ", tid=" + tid + ", regdate=" + regdate + ", category="
				+ category + ", amount=" + amount + ", reps=" + reps + ", hour=" + hour + ", storagemethod="
				+ storagemethod + ", textarea=" + textarea + ", checks=" + checks + ", remark=" + remark + "]";
	}
	
	
	

}
