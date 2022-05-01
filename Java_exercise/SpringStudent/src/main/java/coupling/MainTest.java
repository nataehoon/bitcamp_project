package coupling;

public class MainTest {
	public static void main(String[] args) {
		Sport sport = new Baseball();
		Human soo = new Human(sport);
		
		soo.play();
		soo.stop();
	}
}
