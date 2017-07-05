package com.tarena;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(654, 400); // 设置大小
		frame.setLocationRelativeTo(null); // 居中

		frame.setTitle("飞机大战"); // 设置标题
		frame.setResizable(false); // 禁止最大化
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭按钮设置为结束程序

		frame.add(new GamePanel());

		frame.setVisible(true); // 设置可见
	}

}
