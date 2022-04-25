package kids.board.edu_program.model;

import java.util.Date;

public class Edu_program {
	private int calno ;
	private String tid ;
	private int class_id ;
	private String title ;
	private String content ;
	private String image ;
	private Date regdate ;
	private int readhit ;
	private Date begindate ;
	private Date enddate ;
	private String remark ;
	
	public Edu_program() {}

	public int getCalno() {
		return calno;
	}

	public void setCalno(int calno) {
		this.calno = calno;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getReadhit() {
		return readhit;
	}

	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Edu_program [calno=" + calno + ", tid=" + tid + ", class_id=" + class_id + ", title=" + title
				+ ", content=" + content + ", image=" + image + ", regdate=" + regdate + ", readhit=" + readhit
				+ ", begindate=" + begindate + ", enddate=" + enddate + ", remark=" + remark + "]";
	}
	
	
	

}
