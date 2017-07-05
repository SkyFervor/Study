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

	// 游戏状态
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int OVER = 3;
	int status = START;

	// 飞行物
	Hero hero = new Hero(this, 500, 150);
	List<Bullet> bullets = new ArrayList<Bullet>();
	List<Flying> flyings = new ArrayList<Flying>();
	Boss boss = null;

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
				// 英雄机射击
				if (enterRateIndex % Config.ENTER_HERO_SHOOT == 0)
					bullets.addAll(hero.shoot());

				// 敌机入场
				if (enterRateIndex % Config.ENTER_FLYING == 0) {
					switch (RANDOM.nextInt(Config.ENTER_FLYING)) {
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

				// boss入场判定
				if (boss == null) {
					if (hero.score >= Config.PROMOTION_SCORE
							&& hero.score % Config.PROMOTION_SCORE <= Config.AWARD_AIR) {
						boss = new Boss(GamePanel.this);
						flyings.add(boss);
					}
				}
				// 已入场则射击
				else {
					if (enterRateIndex % Config.ENTER_BOSS_SHOOT == 0)
						flyings.addAll(boss.shoot());
				}

				enterRateIndex++;
			}

			void hit() {
				// 撞击判定
				for (int i = flyings.size() - 1; i >= 0; i--) {
					Flying flying = flyings.get(i);
					if (flying.hit(hero)) {
						if (hero.life == 1) {
							status = OVER;
							return;
						}

						hero.fire = Config.FIRE_HERO;
						hero.life--;

						if (!(flying instanceof Boss))
							flyings.remove(i);
					}
				}

				// 命中判定
				for (int i = bullets.size() - 1; i >= 0; i--) {
					Bullet bullet = bullets.get(i);
					for (int j = flyings.size() - 1; j >= 0; j--) {
						Flying flying = flyings.get(j);
						// 子弹不会命中子弹
						if (flying instanceof Bullet)
							continue;

						// 未命中
						if (!bullet.hit(flying))
							continue;
						// 命中敌机
						if (flying instanceof Airplane)
							hero.score += flying.score;
						// 命中蜜蜂
						else if (flying instanceof Bee) {
							Bee bee = (Bee) flying;
							switch (bee.awardType) {
							case Bee.LIFE_AWARD:
								if (hero.life < Config.LIFE_MAX)
									hero.life += bee.score;
								break;
							case Bee.FIRE_AWARD:
								if (hero.fire < Config.FIRE_MAX)
									hero.fire += bee.score;
							default:
								break;
							}

						}
						// 命中boss
						else {
							if (--boss.life > 0) {
								bullets.remove(i);
								break;
							} else
								boss = null;
						}

						bullets.remove(i); // 移除子弹
						flyings.remove(j); // 移除被命中敌机
						break;
					}
				}
			}
		}
		TimerTask task = new MyTimerTask();
		new Timer().schedule(task, 50, 15);

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

	// 绘制背景
	void paintBackground(Graphics g) {
		g.drawImage(
				ImageUtil.getImage(this.getClass().getResourceAsStream("/background.jpg")), 0,
				0, null);
	}

	// 绘制得分和生命值
	void paintScoreAndLife(Graphics g) {
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.setColor(Color.RED);

		g.drawString("SCORE:" + hero.score, 20, 20);
		g.drawString("LIFE:" + hero.life, 20, 40);
	}

	// 绘制英雄机
	void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}

	// 绘制敌方飞行物
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

	// 绘制状态显示层
	void paintState(Graphics g) {
		BufferedImage image = null;
		switch (status) {
		case START:
			image = ImageUtil.getImage(this.getClass().getResourceAsStream("/start.png"));
			break;
		case RUNNING:
			break;
		case PAUSE:
			image = ImageUtil.getImage(this.getClass().getResourceAsStream("/pause.png"));
			break;
		case OVER:
			image = ImageUtil.getImage(this.getClass().getResourceAsStream("/gameover.png"));
			break;
		}

		g.drawImage(image, 0, 0, null);
	}
}
