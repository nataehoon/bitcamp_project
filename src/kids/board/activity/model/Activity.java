package kids.board.activity.model;

public class Activity {
	private int actino ;
	private int subject_code ;
	private String title ;
	private String content ;
	private String image ;
	private String regdate ;
	private String remark ;
	private String tid ;
	private int class_id ;
	private int readhit ;
	
	public Activity() {}

	public int getActino() {
		return actino;
	}

	public void setActino(int actino) {
		this.actino = actino;
	}

	public int getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(int string) {
		this.subject_code = string;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	

	/**
	 * @return the regdate
	 */
	public String getRegdate() {
		return regdate;
	}

	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getReadhit() {
		return readhit;
	}

	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}

	@Override
	public String toString() {
		return "Activity [actino=" + actino + ", subject_code=" + subject_code + ", title=" + title + ", content="
				+ content + ", image=" + image + ", regdate=" + regdate + ", remark=" + remark + ", tid=" + tid
				+ ", class_id=" + class_id + ", readhit=" + readhit + "]";
	}
	
	
	
	
	
}
