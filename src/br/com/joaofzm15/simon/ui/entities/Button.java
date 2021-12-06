package br.com.joaofzm15.simon.ui.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.simon.sfx.SoundEffect;

public class Button {

	private JButton jButton;

	public JButton getJButton() {
		return jButton;
	}
	
	private int red;
	private int green;
	private int blue;

	public Button(int x, int y, int xSize, int ySize, String text, int red, int green, int blue, int fontSize,ActionListener actionListener) {
		jButton = new JButton();
		jButton.setBounds(x, y, xSize, ySize);
		jButton.setText(text);
		jButton.addActionListener(actionListener);
		jButton.setFont(new Font("Impact", Font.BOLD, fontSize));
		jButton.setForeground(Color.white);
		jButton.setBackground(new Color(red, green, blue));
		jButton.setBorder(BorderFactory.createLineBorder(Color.white));
		jButton.setFocusable(false);
		this.red=red;
		this.green=green;
		this.blue=blue;
	}

	public void refresh() {
		String backUp=jButton.getText();
		jButton.setText("refresh");
		jButton.setText(backUp);
	}

	public void highlight() {
		int newRed = red;
		if (newRed==80) {
			newRed=255;
		}
		int newGreen = green;
		if (newGreen==80) {
			newGreen=255;
		}
		int newBlue = blue;
		if (newBlue==80) {
			newBlue=255;
		}
		jButton.setBackground(new Color(newRed,newGreen,newBlue));
	}
	
	public void unHighlight() {
		jButton.setBackground(new Color(red,green,blue));
	}
	
	public void blink() {
		highlight();
		new Thread(new SoundEffect("/clickSound.wav")).start();
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		    	unHighlight();
		    }
		}, 500);
	}
	
	public void makeButtonsUnfocusable() {
		jButton.setFocusable(false);
	}

	public void setVisible(boolean value) {
		jButton.setVisible(value);
	}
}
