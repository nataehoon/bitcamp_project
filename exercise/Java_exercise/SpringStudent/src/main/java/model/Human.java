package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Human {
	// 상수 값들은 반드시 final 키워드를 사용해야 합니다.
	private final String MUST_INPUT = "필수 입력 사항입니다." ;

	@Length(min=4, max=15, message="아이디는 최소 4자리 최대 15자리 입니다.")
	@NotEmpty(message= "아이디는 " + MUST_INPUT )
	private String id ;
	
	@Length(min=3, max=12, message="이름은 최소 3자리 최대 12자리 입니다.")
	@NotEmpty(message= "이름은 " + MUST_INPUT )	
	private String name ;
	
	@NotNull(message="취미는 반드시 선택해 주셔야 합니다.")
	private String hobby ; //취미(라디오 버튼)
	
	@NotNull(message="특기는 반드시 선택해 주셔야 합니다.")
	private String special ; //특기(체크 박스)		
	
	@NotEmpty(message= "생일은 " + MUST_INPUT )
	private String birth ; //생일	

	@Range(min=1, message="직업을 반드시 선택해 주세요.")
	private String job ; //직업	
	
	@Pattern(regexp = "\\d{4}[-/]\\d{2}[-/]\\d{2}", message = "날짜는 yyyy/MM/dd 또는 yyyy-MM-dd 형식으로 입력해 주세요.")
	private String regdate ;
	
	public Human() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", name=" + name + ", hobby=" + hobby + ", special=" + special + ", birth=" + birth
				+ ", job=" + job + ", regdate=" + regdate + "]";
	}
	
}
