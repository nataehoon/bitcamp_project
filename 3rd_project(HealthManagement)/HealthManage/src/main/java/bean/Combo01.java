package bean;

public class Combo01 {
	private String id;
	private String name;
	private String nickname;
	private int totalcount;
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	@Override
	public String toString() {
		return "Combo01 [id=" + id + ", name=" + name + ", nickname=" + nickname + ", totalcount=" + totalcount + "]";
	}
	
}
