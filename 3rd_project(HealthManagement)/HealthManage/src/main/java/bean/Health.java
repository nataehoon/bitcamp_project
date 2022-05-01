package bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Health {
	private int healthno;
	@NotNull
	private String id;
	@Digits(integer=4, fraction=1,
			message="신장를 소수점 1자리까지만 입력해 주세요.")
	private float height;
	@Digits(integer=4, fraction=1,
			message="몸무게를 소수점 1자리까지만 입력해 주세요.")
	private float weight;
	private float fat;
	private float muscle;
	private int hdl;
	private int ldl;
	private int totalco;
	private int ast;
	private int alt;
	private int ggt;
	private float bun;
	private float creatin;
	private int fbs;
	@NotNull(message="등록일을 선택해 주세요.")
	private String regdate;
	private int systolic;
	private int diastolic;
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getHealthno() {
		return healthno;
	}

	public void setHealthno(int healthno) {
		this.healthno = healthno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getFat() {
		return fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public float getMuscle() {
		return muscle;
	}

	public void setMuscle(float muscle) {
		this.muscle = muscle;
	}

	public int getHdl() {
		return hdl;
	}

	public void setHdl(int hdl) {
		this.hdl = hdl;
	}

	public int getLdl() {
		return ldl;
	}

	public void setLdl(int ldl) {
		this.ldl = ldl;
	}

	public int getTotalco() {
		return totalco;
	}

	public void setTotalco(int totalco) {
		this.totalco = totalco;
	}

	public int getAst() {
		return ast;
	}

	public void setAst(int ast) {
		this.ast = ast;
	}

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public int getGgt() {
		return ggt;
	}

	public void setGgt(int ggt) {
		this.ggt = ggt;
	}

	public float getBun() {
		return bun;
	}

	public void setBun(float bun) {
		this.bun = bun;
	}

	public float getCreatin() {
		return creatin;
	}

	public void setCreatin(float creatin) {
		this.creatin = creatin;
	}

	public int getFbs() {
		return fbs;
	}

	public void setFbs(int fbs) {
		this.fbs = fbs;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	@Override
	public String toString() {
		return "Health [healthno=" + healthno + ", id=" + id + ", height=" + height + ", weight=" + weight + ", fat="
				+ fat + ", muscle=" + muscle + ", hdl=" + hdl + ", ldl=" + ldl + ", totalco=" + totalco + ", ast=" + ast
				+ ", alt=" + alt + ", ggt=" + ggt + ", bun=" + bun + ", creatin=" + creatin + ", fbs=" + fbs
				+ ", regdate=" + regdate + ", systolic=" + systolic + ", diastolic=" + diastolic + "]";
	}

	
}
