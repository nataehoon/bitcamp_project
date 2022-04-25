package kids.members.employees.model;

public class Employees {
	private String tid;
	private int class_id;
	private String name;
	private String join_date;
	private int salary;
	private String image;
	private String birth;
	private String hp;
	private String address1;
	private String address2;
	private String gender;
	private String responsibilities;
	private String password;
	private String submit;
	private int subject_code;
	private String remark;
	private String email;
	private String zipcode;
	private String pid;
	private String class_name;
	private String subject;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(int subject_code) {
		this.subject_code = subject_code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employees() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employees [tid=" + tid + ", class_id=" + class_id + ", name=" + name + ", join_date=" + join_date
				+ ", salary=" + salary + ", image=" + image + ", birth=" + birth + ", hp=" + hp + ", address1="
				+ address1 + ", address2=" + address2 + ", gender=" + gender + ", responsibilities=" + responsibilities
				+ ", password=" + password + ", submit=" + submit + ", subject_code=" + subject_code + ", remark="
				+ remark + ", email=" + email + ", zipcode=" + zipcode + ", pid=" + pid + ", class_name=" + class_name
				+ ", subject=" + subject + "]";
	}
	
}
