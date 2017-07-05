package homework;

import javax.swing.JFrame;

public class MyFrame {

	public static void main(String[] args) {
		int width = 800;
		int height = 600;

		JFrame frame = new JFrame();
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);

		frame.setTitle("作业2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.add(new MyPanel(width, height));
	}

}
