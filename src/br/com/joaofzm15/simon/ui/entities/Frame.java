package br.com.joaofzm15.simon.ui.entities;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {

	private JFrame jFrame;

	public JFrame getJFrame() {
		return jFrame;
	}
	
	public Frame(String backgroundURL, String iconURL) {
		jFrame = new JFrame();
		jFrame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(backgroundURL))));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		ImageIcon windowIcon = new ImageIcon(getClass().getClassLoader().getResource(iconURL));
		jFrame.setIconImage(windowIcon.getImage());
		jFrame.setTitle("Simon");
		jFrame.setResizable(false);
		jFrame.setSize(1280, 720);
		jFrame.setLocationRelativeTo(null);
		jFrame.pack();
		jFrame.setVisible(true);	}

	public void dispose() {
		jFrame.dispose();
	}
}
