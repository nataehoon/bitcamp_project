package bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Diet {
	private int dietno;
	private String id;
	private String regdate;
	@NotNull(message="사진을 업로드 해주세요.")
	private MultipartFile asdf;
	private String image;
	@NotEmpty(message="식단은 필수 입력 사항입니다.")
	private String dietlist;
	private String comments;
	private String remark;
	
	
	public MultipartFile getAsdf() {
		return asdf;
	}
	public void setAsdf(MultipartFile asdf) {
		
		if(asdf != null) {
			this.image = asdf.getOriginalFilename();
		}
		
		this.asdf = asdf;
	}
	public int getDietno() {
		return dietno;
	}
	public void setDietno(int dietno) {
		this.dietno = dietno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDietlist() {
		return dietlist;
	}
	public void setDietlist(String dietlist) {
		this.dietlist = dietlist;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Diet [dietno=" + dietno + ", id=" + id + ", regdate=" + regdate + ", image=" + image + ", dietlist="
				+ dietlist + ", comments=" + comments + ", remark=" + remark + "]";
	}
	
	
}
