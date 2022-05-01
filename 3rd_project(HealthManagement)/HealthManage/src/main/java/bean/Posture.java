package bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Posture {
	private int pono;
	private String id;
	@NotEmpty(message="등록일을 선택해 주세요.")
	private String regdate;
	@NotNull(message="사진은 반드시 첨부하셔야 합니다.")
	private MultipartFile front;
	private String image1;
	@NotNull(message="사진은 반드시 첨부하셔야 합니다.")
	private MultipartFile back;
	private String image2;
	@NotNull(message="사진은 반드시 첨부하셔야 합니다.")
	private MultipartFile left;
	private String image3;
	@NotNull(message="사진은 반드시 첨부하셔야 합니다.")
	private MultipartFile right;
	private String image4;
	private String remark;
	private String comments;
	private int num;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public MultipartFile getFront() {
		return front;
	}
	public void setFront(MultipartFile front) {
		if (this.front != null) {
			this.image1 = this.front.getOriginalFilename();
		}
		this.front = front;
	}
	public MultipartFile getBack() {
		return back;
	}
	public void setBack(MultipartFile back) {
		if (this.back != null) {
			this.image2 = this.back.getOriginalFilename();
		}
		this.back = back;
	}
	public MultipartFile getLeft() {
		return left;
	}
	public void setLeft(MultipartFile left) {
		if (this.left != null) {
			this.image3 = this.left.getOriginalFilename();
		}
		this.left = left;
	}
	public MultipartFile getRight() {
		return right;
	}
	public void setRight(MultipartFile right) {
		if (this.right != null) {
			this.image4 = this.right.getOriginalFilename();
		}
		this.right = right;
	}
	public int getPono() {
		return pono;
	}
	public void setPono(int pono) {
		this.pono = pono;
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
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getImage4() {
		return image4;
	}
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Posture [pono=" + pono + ", id=" + id + ", regdate=" + regdate + ", image1=" + image1 + ", image2="
				+ image2 + ", image3=" + image3 + ", image4=" + image4 + ", remark=" + remark + ", comments=" + comments
				+ "]";
	}
	
	
}
