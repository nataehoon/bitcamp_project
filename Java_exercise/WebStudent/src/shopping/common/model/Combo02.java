package shopping.common.model;

public class Combo02 {
	private String name ; // 이름
	private int cnt ; // 게시물 작성 건수
	
	
	@Override
	public String toString() {
		return "Combo02 [name=" + name + ", cnt=" + cnt + "]";
	}

	public Combo02() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	

	
	
}