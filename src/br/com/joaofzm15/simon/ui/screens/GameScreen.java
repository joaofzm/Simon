package br.com.joaofzm15.simon.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.com.joaofzm15.simon.sfx.SoundEffect;
import br.com.joaofzm15.simon.ui.entities.Best;
import br.com.joaofzm15.simon.ui.entities.Button;
import br.com.joaofzm15.simon.ui.entities.Frame;
import br.com.joaofzm15.simon.ui.entities.Score;


public class GameScreen implements ActionListener
{
	protected GameScreenController controller;

	protected Frame frame;
	
	protected Button startButton;
	protected Button exitButton;
	protected Score score;
	protected Best best;
	
	protected Button green;
	protected Button red;
	protected Button yellow;
	protected Button blue;
	
	public GameScreen() {
		controller = new GameScreenController(this);
		frame = new Frame("background.png","icon.png");
		
		score = new Score();
		frame.getJFrame().add(score.getJLabel());
		
		best = new Best();
		frame.getJFrame().add(best.getJLabel());
		
		startButton = new Button(225, 500, 180, 60, "S T A R T", 0, 200, 0, 26, this);
		frame.getJFrame().add(startButton.getJButton());
		
		exitButton = new Button(240, 600, 150, 60, "E X I T", 200, 0, 0, 22, this);
		frame.getJFrame().add(exitButton.getJButton());
		
		green = new Button(610, 50, 310, 310, "", 0, 80, 0, 22, this);
		frame.getJFrame().add(green.getJButton());
		red = new Button(920, 50, 310, 310, "", 80, 0, 0, 22, this);
		frame.getJFrame().add(red.getJButton());
		
		yellow = new Button(610, 360, 310, 310, "", 80, 80, 0, 22, this);
		frame.getJFrame().add(yellow.getJButton());
		blue = new Button(920, 360, 310, 310, "", 0, 0, 80, 22, this);
		frame.getJFrame().add(blue.getJButton());
		

		refreshComponents();
	}

	public void threadSleep20() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void refreshComponents() {
		startButton.refresh();
		threadSleep20();
		exitButton.refresh();
		threadSleep20();
		score.refresh();
		threadSleep20();
		best.refresh();
		threadSleep20();
		green.refresh();
		threadSleep20();
		red.refresh();
		threadSleep20();
		yellow.refresh();
		threadSleep20();
		blue.refresh();
		threadSleep20();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exitButton.getJButton()) {
			controller.exit();
			return;
		}
		
		if (e.getSource() == startButton.getJButton()) {
			controller.cpuTurn();
			startButton.getJButton().setEnabled(false);
			return;
		}
		
		if (controller.playerEnabled) {

			if (e.getSource() == green.getJButton()) {
				green.blink();
				controller.checkIfCorrect(1);
				return;
			}
			
			if (e.getSource() == red.getJButton()) {
				red.blink();
				controller.checkIfCorrect(2);
				return;
			}
			
			if (e.getSource() == yellow.getJButton()) {
				yellow.blink();
				controller.checkIfCorrect(3);
				return;
			}
			
			if (e.getSource() == blue.getJButton()) {
				blue.blink();
				controller.checkIfCorrect(4);
				return;
			}
		}
	}
}
