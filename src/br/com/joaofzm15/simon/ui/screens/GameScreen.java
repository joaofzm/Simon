package br.com.joaofzm15.simon.ui.screens;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import br.com.joaofzm15.simon.ui.entities.Frame;


public class GameScreen implements ActionListener
{
	protected GameScreenController controller;

	protected Frame frame;

	public GameScreen() {

//		controller = new GameScreenController(this);

		frame = new Frame("background.png");

//		refreshComponents();
	}

	public void threadSleep20() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method is required as a workaround interaction for java swing no
	 * properly showing the components when the program loads. By doing one action
	 * on all the components, such as updating it's text or just commanding it to
	 * request focus, we can guarantee all components will be shown.
	 */
	public void refreshComponents() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
