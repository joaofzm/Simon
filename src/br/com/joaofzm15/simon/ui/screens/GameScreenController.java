package br.com.joaofzm15.simon.ui.screens;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import br.com.joaofzm15.simon.sfx.SoundEffect;

public class GameScreenController {
	
	private GameScreen gs;
	protected ArrayList<Integer> sequence;
	protected boolean playerEnabled = false;
	
	
	public GameScreenController(GameScreen gameScreen) {
		gs = gameScreen;
		sequence = new ArrayList<>();
	}
	
	protected int nextInputIndex = 0;
	
	public void checkIfCorrect(int option) {
		if (sequence.get(nextInputIndex)==option) {
			nextInputIndex++;
			if (nextInputIndex==sequence.size()) {
				nextInputIndex=0;
				playerEnabled=false;
				gs.score.increase();
				gs.best.setBest(gs.score.getScore());
				new Thread(new SoundEffect("/correct.wav")).start();
				
				new Timer().schedule(new TimerTask() {          
				    @Override
				    public void run() {
				    	cpuTurn();
				    }
				}, 1300);
			}
		
		} else {
			sequence.clear();
			nextInputIndex=0;
			playerEnabled=false;
			gs.score.reset();
			gs.startButton.getJButton().setVisible(true);
			new Thread(new SoundEffect("/error.wav")).start();
			System.out.println("You lose");
		}
	}
	
	public void cpuTurn() {
		drawNextButton();
		blinkAnimation();
	}
	
	private void drawNextButton() {
		int next = 1 + (int)(Math.random() * ((4 - 1) + 1));
		sequence.add(next);
	}
	
	public void blinkAnimation() {
		playerEnabled=false;
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		    	playerEnabled=true;
		    }
		}, sequence.size()*800);
		
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
