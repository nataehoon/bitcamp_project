package kids.board.diet.model;

public class Diet {
	private int dietno;
	private String regdate;
	private String files;
	private String category;
	private String content;
	private String remark;
	
	public int getDietno() {
		return dietno;
	}
	public void setDietno(int dietno) {
		this.dietno = dietno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Diet [dietno=" + dietno + ", regdate=" + regdate + ", files=" + files + ", category=" + category
				+ ", content=" + content + ", remark=" + remark + "]";
	}
	
}
