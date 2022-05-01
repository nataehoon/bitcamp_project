package mycomputer;

public class Programmer {
	private String name;
	private String address;
	private Computer computer;
	
	public Programmer(String name, String address, Computer computer) {
		this.name = name;
		this.address = address;
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "Programmer [name=" + name + ", address=" + address + ", computer=" + computer + "]";
	}
	
}
