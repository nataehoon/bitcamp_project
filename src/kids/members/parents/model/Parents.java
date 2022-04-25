package kids.members.parents.model;

public class Parents {
	
	private String pid ;
	private int sid ;
	private String name ;
	private String hp ;
	private String address1 ;
	private String address2 ;
	private String gender ;
	private String relationship ;
	private String submit ;
	private String birth ;
	private String password ;
	private String email ;
	private String image ;
	private int childid ;
	private int childid2 ;
	private String remark ;
	private String zipcode ;
	private String responsibilities;
	
	public String getResponsibilities() {
		return responsibilities;
	}


	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}


	public Parents() {}

	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}


	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getChildid() {
		return childid;
	}

	public void setChildid(int childid) {
		this.childid = childid;
	}

	public int getChildid2() {
		return childid2;
	}

	public void setChildid2(int childid2) {
		this.childid2 = childid2;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Parents [pid=" + pid + ", sid=" + sid + ", name=" + name + ", hp=" + hp + ", address1=" + address1
				+ ", address2=" + address2 + ", gender=" + gender + ", relationship=" + relationship + ", submit="
				+ submit + ", birth=" + birth + ", password=" + password + ", email=" + email + ", image=" + image
				+ ", childid=" + childid + ", childid2=" + childid2 + ", remark=" + remark + ", zipcode=" + zipcode
				+ "]";
	}
	
	
}
