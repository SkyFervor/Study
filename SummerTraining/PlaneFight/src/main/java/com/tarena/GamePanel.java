package com.tarena;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class GamePanel extends JPanel {
	public static final long serialVersionUID = 1L;
	public static final Random RANDOM = new Random();

	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int OVER = 3;
	int status = START;

	Hero hero = new Hero(150, 400);
	List<Bullet> bullets = new ArrayList<Bullet>();
	List<Flying> flyings = new ArrayList<Flying>();

	GamePanel() {
		class MyTimerTask extends TimerTask {
			@Override
			public void run() {
				if (status == RUNNING) {
					step();
					enter();
					hit();
				}
				repaint();
			}

			void step() {
				hero.step();

				for (int i = bullets.size() - 1; i >= 0; i--) {
					Bullet bullet = bullets.get(i);
					bullet.step();
					if (bullet.outOfBounds())
						bullets.remove(i);
				}

				for (int i = flyings.size() - 1; i >= 0; i--) {
					Flying flying = flyings.get(i);
					flying.step();
					if (flying.outOfBounds())
						flyings.remove(i);
				}
			}

			int enterRateIndex = 0;

			void enter() {
				if (enterRateIndex % Constant.ENTER_RATE_BULLET == 0)
					bullets.addAll(hero.shoot());

				if (enterRateIndex % Constant.ENTER_RATE_FLY == 0) {
					switch (RANDOM.nextInt(Constant.ENTER_RATE_FLY)) {
					case 0:
						Bee bee = new Bee(GamePanel.this);
						flyings.add(bee);
						break;
					default:
						Airplane air = new Airplane(GamePanel.this);
						flyings.add(air);
						break;
					}
				}

				enterRateIndex++;
			}

			void hit() {
				for (int i = flyings.size() - 1; i >= 0; i--) {
					Flying flying = flyings.get(i);
					if (flying.hit(hero)) {
						if (hero.life == 1) {
							status = OVER;
							return;
						}

						hero.fire = Constant.INITIAL_FIRE;
						hero.life--;
						flyings.remove(i);
					}
				}
				for (int i = bullets.size() - 1; i >= 0; i--) {
					Bullet bullet = bullets.get(i);
					for (int j = flyings.size() - 1; j >= 0; j--) {
						Flying flying = flyings.get(j);
						if (!bullet.hit(flying))
							continue;

						if (flying instanceof Airplane)
							hero.score += flying.score;
						else if (flying instanceof Bee) {
							Bee bee = (Bee) flying;
							switch (bee.awardType) {
							case Bee.LIFE_AWARD:
								if (hero.life < Constant.MAX_LIFE)
									hero.life += bee.score;
								break;
							case Bee.FIRE_AWARD:
								if (hero.fire < Constant.MAX_FIRE)
									hero.fire += bee.score;
							default:
								break;
							}
						}
						bullets.remove(i);
						flyings.remove(j);
						break;
					}
				}
			}
		}
		TimerTask task = new MyTimerTask();
		new Timer().schedule(task, 0, 10);

		class MouseListener extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (status == START)
					status = RUNNING;
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				if (status == RUNNING)
					hero.moveTo(e.getX(), e.getY());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (status == RUNNING)
					status = PAUSE;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (status == PAUSE)
					status = RUNNING;
			}
		}
		MouseListener listener = new MouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		paintBackground(g);
		paintFlyings(g);
		paintHero(g);
		paintScoreAndLife(g);
		paintState(g);
	}

	void paintBackground(Graphics g) {
		g.drawImage(ImageUtil.getImage("res/background.png"), 0, 0, null);
	}

	void paintScoreAndLife(Graphics g) {
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.setColor(Color.RED);

		g.drawString("SCORE:" + hero.score, 20, 20);
		g.drawString("LIFE:" + hero.life, 20, 40);
	}

	void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}

	void paintFlyings(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			g.drawImage(bullet.image, bullet.x, bullet.y, null);
		}

		for (int i = 0; i < flyings.size(); i++) {
			Flying flying = flyings.get(i);
			g.drawImage(flying.image, flying.x, flying.y, null);
		}
	}

	void paintState(Graphics g) {
		BufferedImage image = null;
		switch (status) {
		case START:
			image = ImageUtil.getImage("res/start.png");
			break;
		case RUNNING:
			break;
		case PAUSE:
			image = ImageUtil.getImage("res/pause.png");
			break;
		case OVER:
			image = ImageUtil.getImage("res/gameover.png");
			break;
		}

		g.drawImage(image, 0, 0, null);
	}

}
