package br.com.joaofzm15.simon.ui.screens;

public class GameScreenController {
	
	private GameScreen gs;
	public  GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
	}
	
	public void exit() {
//		new Thread(new SoundEffect("/clickSound.wav")).start();
		try {
			Thread.sleep(900);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}

}
