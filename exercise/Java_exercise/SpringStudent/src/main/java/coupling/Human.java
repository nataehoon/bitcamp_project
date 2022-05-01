package coupling;

public class Human {
	private Sport sport;
	
	public Human(Sport sport) {
		this.sport = sport;
	}
	
	public void play() {
		sport.play();
	}
	
	public void stop() {
		sport.stop();
	}

}
