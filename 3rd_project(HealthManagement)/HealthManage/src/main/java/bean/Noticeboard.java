package bean;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class Noticeboard {
	private int notino;
	@Length(min = 3, message="글 제목은 최소 3글자 이상 입니다.")
	private String title;
	@Length(min = 1, message="내용을 작성해 주세요.")
	private String content;
	private MultipartFile asdf;
	private String image;
	private String regdate;
	private String remark;
	
	public MultipartFile getAsdf() {
		return asdf;
	}
	public void setAsdf(MultipartFile asdf) {
		if(this.asdf !=null) {
			this.image = this.asdf.getOriginalFilename();
		}
		this.asdf = asdf;
	}
	public int getNotino() {
		return notino;
	}
	public void setNotino(int notino) {
		this.notino = notino;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Noticeboard [notino=" + notino + ", title=" + title + ", content=" + content + ", image=" + image
				+ ", regdate=" + regdate + ", remark=" + remark + "]";
	}
	
	
}
