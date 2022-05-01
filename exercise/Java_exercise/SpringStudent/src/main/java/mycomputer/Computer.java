package mycomputer;

public class Computer {
	private String Cpu;
	private String Hdd;
	private String Mainboard;


	public void setCpu(String cpu) {
		Cpu = cpu;
	}
	public void setHdd(String hdd) {
		Hdd = hdd;
	}
	public void setMainboard(String mainboard) {
		Mainboard = mainboard;
	}
	@Override
	public String toString() {
		return "Computer01 [Cpu=" + Cpu + ", Hdd=" + Hdd + ", Mainboard=" + Mainboard + "]";
	}
	
	
}
