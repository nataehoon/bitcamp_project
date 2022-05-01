package bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Member {
	@NotEmpty(message = "아이디는 필수 입력 사항입니다.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z]).{4,10}$", 
			message="아이디는 영문(소문자), 숫자 조합으로 최소 4자리 이상 최대 10자리 입니다.")
	private String id;
	@Pattern(regexp="^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z]).{6,12}$", 
			message="비밀번호는 영문(소문자), 숫자, 특수문자 조합으로 최소 6자리 이상 최대 12자리 입니다.")
	private String password;
	@Length(min=2, max=10, message = "이름은 최소 2자리 이상 최대 10자리 입니다.")
	private String name;
	@Pattern(regexp="^(?=.*\\d).{1,3}$", 
			message="나이를 숫자만 입력해 주세요.")
	private String age;
	@Length(min=10, max=11, message = "핸드폰 번호는 '-'를 제외한 10자리 또는 11자리로 입력하셔야 합니다.")
	private String hp;
	@Pattern(regexp="^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\\*]+$")
	@Length(min=2, max=6, message = "닉네임은 2자리 이상 6자리 이하로 입력하셔야 합니다.")
	private String nickname;
	@Email
	@NotEmpty(message = "이메일을 입력해 주세요.")
	private String email;
	private MultipartFile asdf;
	private String image;
	@NotEmpty(message = "우편번호는 필수 입력 사항입니다.")
	private String zipcode;
	@NotEmpty(message = "주소는 필수 입력 사항입니다.")
	private String address;
	private String address2;
	@NotNull(message = "병력은 반드시 체크가 되어야 합니다.")
	private String mehi;
	@NotEmpty(message = "생활패턴은 필수 입력 사항입니다.")
	private String workpattern;
	@Digits(integer=3, fraction=1,
			message="몸무게를 소수점 1자리까지만 입력해 주세요.")
	private float weight;
	@Digits(integer=4, fraction=1,
			message="신장를 소수점 1자리까지만 입력해 주세요.")
	private float height;
	@NotEmpty(message = "수술여부는 필수 입력 사항입니다.")
	private String postop;
	private String memo;
	private String remark;
	@NotEmpty(message = "성별은 필수 체크 사항입니다.")
	private String gender;
	
	public MultipartFile getAsdf() {
		return asdf;
	}
	public void setAsdf(MultipartFile asdf) {
		
		if(asdf != null) {
			this.image = asdf.getOriginalFilename();
		}
		
		this.asdf = asdf;
	}
	public Member() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getMehi() {
		return mehi;
	}
	public void setMehi(String mehi) {
		this.mehi = mehi;
	}
	public String getWorkpattern() {
		return workpattern;
	}
	public void setWorkpattern(String workpattern) {
		this.workpattern = workpattern;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getPostop() {
		return postop;
	}
	public void setPostop(String postop) {
		this.postop = postop;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", hp=" + hp
				+ ", nickname=" + nickname + ", email=" + email + ", image=" + image + ", zipcode=" + zipcode
				+ ", address=" + address + ", address2=" + address2 + ", mehi=" + mehi + ", workpattern=" + workpattern
				+ ", weight=" + weight + ", height=" + height + ", postop=" + postop + ", memo=" + memo + ", remark="
				+ remark + ", gender=" + gender + "]";
	}
	
}
