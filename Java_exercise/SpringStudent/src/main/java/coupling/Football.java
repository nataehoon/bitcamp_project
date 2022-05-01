package coupling;

public class Football implements Sport {

	@Override
	public void play() {
		System.out.println("축구 게임을 합니다.");
		
	}

	@Override
	public void stop() {
		System.out.println("축구 게임을 중지합니다.");
		
	}

}
