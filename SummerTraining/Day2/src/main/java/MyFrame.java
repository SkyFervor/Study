import javax.swing.JFrame;

public class MyFrame {

	public static void main(String[] args) {
		int width = 800;
		int height = 600;
		
		JFrame frame = new JFrame();
		// frame.setAlwaysOnTop(true);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		
		// frame.setIconImage(image);
		frame.setTitle("MyFrame");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		MyPanel myPanel = new MyPanel(width, height);
		frame.add(myPanel);
	}

}
