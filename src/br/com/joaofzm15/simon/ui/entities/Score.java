package br.com.joaofzm15.simon.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Score {

	private JLabel jLabel;
	
	public JLabel getJLabel() {
		return jLabel;
	}
	
	private int score = 0;
	public int getScore() {
		return score;
	}
	public void setScore(int value) {
		score=value;
		jLabel.setText("Score: "+score);
	}

	public Score() {
		jLabel = new JLabel();
		jLabel.setBounds(200,170,1000,300);
		jLabel.setLayout(null);
		jLabel.setText("Score: "+score);
		jLabel.setFont(new Font("Impact",Font.BOLD, 60));
		jLabel.setForeground(new Color(255,255,255));
		jLabel.setVisible(true);
	}
	
	public void resetCounter() {
		score = 0;
		jLabel.setText("Score: "+score);
	}
	
	public void increaseCounter() {
		score++;
		jLabel.setText("Score: "+score);
	}

	public void refresh() {
		int backUp = score;
		increaseCounter();
		setScore(backUp);
	}
	
}
