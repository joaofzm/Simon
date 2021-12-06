package br.com.joaofzm15.simon.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.simon.ui.entities.BestLabel;
import br.com.joaofzm15.simon.ui.entities.Button;
import br.com.joaofzm15.simon.ui.entities.Frame;
import br.com.joaofzm15.simon.ui.entities.Score;


public class GameScreen implements ActionListener
{
	protected GameScreenController controller;

	protected Frame frame;
	protected Button exitButton;
	protected Score score;
	protected BestLabel bestLabel;

	public GameScreen() {
		controller = new GameScreenController(this);
		frame = new Frame("background.png");
		
		exitButton = new Button(240, 600, 150, 60, "E X I T", 100, 0, 0, 22, this);
		frame.getJFrame().add(exitButton.getJButton());
		
		bestLabel = new BestLabel();
		frame.getJFrame().add(bestLabel.getJLabel());
		
		score = new Score();
		frame.getJFrame().add(score.getJLabel());

//		refreshComponents();
	}

	public void threadSleep20() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void refreshComponents() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton.getJButton()) {
			controller.exit();
			return;
		}
	}
}
