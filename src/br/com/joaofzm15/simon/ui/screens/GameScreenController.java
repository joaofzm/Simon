package br.com.joaofzm15.simon.ui.screens;

import java.util.ArrayList;

public class GameScreenController {
	
	private GameScreen gs;
	protected ArrayList<Integer> sequence;
	protected boolean playerEnabled = true;
	
	public GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
		sequence = new ArrayList<>();
	}
	
	private void drawNextButton() {
		int next = 1 + (int)(Math.random() * ((4 - 1) + 1));
		sequence.add(next);
	}
	
	private void threadSleep800() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void blinkAnimation() {
		playerEnabled=false;
		for (Integer integer : sequence) {
			if (integer==1) {
				gs.green.highlight();
				threadSleep800();
				gs.green.unHighlight();
			} else if (integer==2) {
				gs.red.highlight();
				threadSleep800();
				gs.red.unHighlight();
			} else if (integer==3) {
				gs.yellow.highlight();
				threadSleep800();
				gs.yellow.unHighlight();
			} else if (integer==4) {
				gs.blue.highlight();
				threadSleep800();
				gs.blue.unHighlight();
			}
		}
		playerEnabled=true;
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
