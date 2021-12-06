package br.com.joaofzm15.simon.ui.entities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class BestLabel {
	private JLabel jLabel;
	public JLabel getJLabel() {
		return jLabel;
	}
	
	private int best = 0;

	public BestLabel() {
		jLabel = new JLabel();
		jLabel.setBounds(250,270,1000,300);
		jLabel.setLayout(null);
		jLabel.setText("Best : 0");
		jLabel.setFont(new Font("Impact",Font.BOLD, 40));
		jLabel.setForeground(new Color(255,255,255));
		jLabel.setVisible(true);
	}
	
	public void setBest(int value) {
		if (value>best) {
			best = value;
			jLabel.setText("Best : "+best);
		}
	}
	
	public void refresh() {
		int backUp = best;
		setBest(-1000);
		setBest(backUp);
	}
}
