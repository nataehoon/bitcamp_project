package bean;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bono;
	private String id;
	private int pono;
	private int logno;
	private int healthno;
	private String category;
	@Length(min = 3, message="글 제목은 최소 3글자 이상 입니다.")
	private String title;
	@Length(min = 1, message="내용을 작성해 주세요.")
	private String content;
	private MultipartFile asdf;
	private String image;
	private String regdate;
	private int readhit;
	private int recommend;
	private String remark;
	private int num;
	private String nickname;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public MultipartFile getAsdf() {
		return asdf;
	}
	public void setAsdf(MultipartFile asdf) {
		
		if (this.asdf != null) {
			this.image = this.asdf.getOriginalFilename();
		}
		
		this.asdf = asdf;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getPono() {
		return pono;
	}
	public void setPono(int pono) {
		this.pono = pono;
	}
	public int getLogno() {
		return logno;
	}
	public void setLogno(int logno) {
		this.logno = logno;
	}
	public int getHealthno() {
		return healthno;
	}
	public void setHealthno(int healthno) {
		this.healthno = healthno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadhit() {
		return readhit;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Board [bono=" + bono + ", id=" + id + ", pono=" + pono + ", logno=" + logno + ", healthno=" + healthno
				+ ", category=" + category + ", title=" + title + ", content=" + content + ", asdf=" + asdf + ", image="
				+ image + ", regdate=" + regdate + ", readhit=" + readhit + ", recommend=" + recommend + ", remark="
				+ remark + ", num=" + num + "]";
	}
	
}
