package br.com.joaofzm15.simon.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Score {

	private JLabel jLabel;
	private int score = 0;
	
	public JLabel getJLabel() {
		return jLabel;
	}
	
	public int getScore() {
		return score;
	}

	public Score() {
		jLabel = new JLabel();
		jLabel.setBounds(200,170,1000,300);
		jLabel.setLayout(null);
		jLabel.setText("Score: "+score);
		jLabel.setFont(new Font("Impact",Font.BOLD, 60));
		jLabel.setForeground(new Color(255,187,0));
		jLabel.setVisible(true);
	}
	
	public void refreshLabel() {
		jLabel.requestFocus();
	}

	public void resetCounter() {
		score = 0;
		jLabel.setText("Moves: "+score);
	}

	public void requestFocus() {
		jLabel.requestFocus();
	}
	
	public void increaseCounter() {
		score++;
		jLabel.setText("Moves: "+score);
	}
}
