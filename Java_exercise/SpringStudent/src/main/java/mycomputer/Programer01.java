package mycomputer;

public class Programer01 {
	private String name;
	private String address;
	private Computer01 computer;// 프로그래머가 컴퓨터에 의존
	
	
	public Programer01(String name, String address) {
		this.name = name;
		this.address = address;
		
		this.computer = new Computer01(); // 객체 생성
		
		computer.setCpu("인텔 시피유");
		computer.setHdd(address);
		computer.setMainboard("엘지 메인보드");
		
	}
	
	@Override
	public String toString() {
		return "Programer01 [name=" + name + ", address=" + address + ", computer=" + computer + "]";
	}
	
}
