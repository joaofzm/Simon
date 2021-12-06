package br.com.joaofzm15.simon.ui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.simon.ui.entities.Button;
import br.com.joaofzm15.simon.ui.entities.Frame;


public class GameScreen implements ActionListener
{
	protected GameScreenController controller;

	protected Frame frame;
	protected Button exitButton;


	public GameScreen() {
//		controller = new GameScreenController(this);
		frame = new Frame("background.png");
		
		exitButton = new Button(240, 600, 150, 60, "E X I T", 100, 0, 0, 22, this);
		frame.getJFrame().add(exitButton.getJButton());

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

	}
}
