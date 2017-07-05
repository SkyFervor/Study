package com.tarena;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 654);
		frame.setLocationRelativeTo(null);

		frame.setTitle("飞机大战");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new GamePanel());

		frame.setVisible(true);
	}

}
