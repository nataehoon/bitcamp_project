package mycomputer;

public class Computer01 {
	private String Cpu;
	private String Hdd;
	private String Mainboard;
	
	public Computer01() {
		// TODO Auto-generated constructor stub
	}
	public String getCpu() {
		return Cpu;
	}
	public void setCpu(String cpu) {
		Cpu = cpu;
	}
	public String getHdd() {
		return Hdd;
	}
	public void setHdd(String hdd) {
		Hdd = hdd;
	}
	public String getMainboard() {
		return Mainboard;
	}
	public void setMainboard(String mainboard) {
		Mainboard = mainboard;
	}
	@Override
	public String toString() {
		return "Computer01 [Cpu=" + Cpu + ", Hdd=" + Hdd + ", Mainboard=" + Mainboard + "]";
	}
	
	
}
