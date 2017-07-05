import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	int[] x_star = new int[300];
	int[] y_star = new int[300];
	int x_moon, y_moon;
	Random rand = new Random();

	public MyPanel(int width, int height) {
		this.width = width;
		this.height = height;

		for (int i = 0; i < 300; i++) {
			x_star[i] = rand.nextInt(width);
			y_star[i] = rand.nextInt(height);
		}
		x_moon = 200;
		y_moon = 0;

		// 利用Timer定时重绘
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		new Timer().schedule(task, 100, 80);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		paintMoon(g);
		paintStar(g);
	}

	/**
	 * 绘制月亮
	 * 
	 * @param g
	 */
	private void paintMoon(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(100, 100, 100, 100);

		g.setColor(Color.BLACK);
		g.fillOval(x_moon, y_moon, 100, 100);
		x_moon -= 5;
		if (x_moon < 0)
			x_moon += 200;
		y_moon = (y_moon + 5) % 200;
	}

	/**
	 * 绘制星星
	 * 
	 * @param g
	 */
	private void paintStar(Graphics g) {
		setBackground(Color.BLACK);

		Font font = new Font("微软雅黑", Font.BOLD, 30);
		g.setFont(font);

		for (int i = 0; i < 300; i++) {
			Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand
					.nextInt(256));
			g.setColor(c);
			g.drawString("*", x_star[i], y_star[i]);
			x_star[i] = (x_star[i] + 5) % width;
			y_star[i] = (y_star[i] + 5) % height;
		}
	}
}
