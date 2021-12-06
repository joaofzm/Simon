package br.com.joaofzm15.simon.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.simon.ui.entities.Best;
import br.com.joaofzm15.simon.ui.entities.Button;
import br.com.joaofzm15.simon.ui.entities.Frame;
import br.com.joaofzm15.simon.ui.entities.Score;


public class GameScreen implements ActionListener
{
	protected GameScreenController controller;

	protected Frame frame;
	
	protected Button exitButton;
	protected Score score;
	protected Best bestLabel;
	
	protected Button green;
	protected Button red;
	protected Button yellow;
	protected Button blue;

	public GameScreen() {
		controller = new GameScreenController(this);
		frame = new Frame("background.png","icon.png");
		
		score = new Score();
		frame.getJFrame().add(score.getJLabel());
		
		bestLabel = new Best();
		frame.getJFrame().add(bestLabel.getJLabel());
		
		exitButton = new Button(240, 600, 150, 60, "E X I T", 0, 135, 255, 22, this);
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
		exitButton.refresh();
		threadSleep20();
		score.refresh();
		threadSleep20();
		bestLabel.refresh();
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
		
		if (e.getSource() == green.getJButton()) {
			green.highlight();
			return;
		}
		
		if (e.getSource() == red.getJButton()) {
			red.highlight();
			return;
		}
		
		if (e.getSource() == yellow.getJButton()) {
			yellow.highlight();
			return;
		}
		
		if (e.getSource() == blue.getJButton()) {
			blue.highlight();
			return;
		}
	}
}
