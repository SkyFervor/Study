package homework;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	int i = 0;

	public MyPanel(int width, int height) {
		this.width = width;
		this.height = height;

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		new Timer().schedule(task, 50, 10);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.WHITE);

		paintTurtle(g);
	}

	private void paintTurtle(Graphics g) {
		g.setColor(Color.YELLOW);
		// 头
		g.fillOval(i + 385, 180, 30, 60);

		// 四肢
		g.fillOval(i + 340, 220, 20, 40);
		g.fillOval(i + 440, 220, 20, 40);
		g.fillOval(i + 340, 340, 20, 40);
		g.fillOval(i + 440, 340, 20, 40);

		// 尾巴
		g.fillOval(i + 395, 360, 40, 50);
		g.setColor(Color.WHITE);
		g.fillOval(i + 405, 370, 40, 50);

		// 背壳
		g.setColor(Color.GREEN);
		g.fillOval(i + 340, 220, 120, 160);

		g.setColor(Color.BLACK);
		// 眼睛
		g.fillOval(i + 390, 190, 7, 7);
		g.fillOval(i + 403, 190, 7, 7);

		// 壳纹
		g.drawLine(i + 400, 280, i + 417, 290);
		g.drawLine(i + 417, 290, i + 417, 310);
		g.drawLine(i + 417, 310, i + 400, 320);
		g.drawLine(i + 400, 320, i + 383, 310);
		g.drawLine(i + 383, 310, i + 383, 290);
		g.drawLine(i + 383, 290, i + 400, 280);

		g.drawLine(i + 400, 280, i + 400, 220);
		g.drawLine(i + 417, 290, i + 450, 260);
		g.drawLine(i + 417, 310, i + 450, 340);
		g.drawLine(i + 400, 320, i + 400, 380);
		g.drawLine(i + 383, 310, i + 350, 340);
		g.drawLine(i + 383, 290, i + 350, 260);

		i++;
		if (i >= width-340)
			i = -460;
	}
}
