package br.com.joaofzm15.simon.ui.screens;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreenController {
	
	private GameScreen gs;
	protected ArrayList<Integer> sequence;
	protected boolean playerEnabled = true;
	
	public GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
		sequence = new ArrayList<>();
	}
	
	public void cpuTurn() {
		playerEnabled=false;
		drawNextButton();
		blinkAnimation();
		playerEnabled=true;
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
		int priority = 0;
		for (Integer integer : sequence) {
			new Timer().schedule(new TimerTask() {          
			    @Override
			    public void run() {
					if (integer==1) {
						gs.green.blink();
					} else if (integer==2) {
						gs.red.blink();
					} else if (integer==3) {
						gs.yellow.blink();
					} else if (integer==4) {
						gs.blue.blink();
					}   
			    }
			}, priority*800);
			priority++;
		}
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
