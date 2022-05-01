package bean;

public class Comment {
	private int cono;
	private int bono;
	private String id;
	private String content;
	private String id2;
	private String regdate;
	private String groupno;
	private String depth;
	private String remark;
	
	public int getCono() {
		return cono;
	}
	public void setCono(int cono) {
		this.cono = cono;
	}
	public int getBono() {
		return bono;
	}
	public void setBono(int bono) {
		this.bono = bono;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGroupno() {
		return groupno;
	}
	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Comment [cono=" + cono + ", bono=" + bono + ", id=" + id + ", content=" + content + ", id2=" + id2
				+ ", regdate=" + regdate + ", groupno=" + groupno + ", depth=" + depth + ", remark=" + remark + "]";
	}
	
	
}
