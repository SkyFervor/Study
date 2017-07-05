package com.tarena;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Boss extends Flying {
	int life = Config.LIFE_BOSS; // 初始化生命值
	int fire = Config.FIRE_BOSS; // 初始化火力

	int speedX = Config.SPEED_BOSS_X;
	int speedY = Config.SPEED_BOSS_Y; // 设置飞行速度

	// 随机确定起始飞行方向
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	int directX = RIGHT;
	public static final int UP = 0;
	public static final int DOWN = 1;
	int directY = RANDOM.nextInt(2);

	Boss(JPanel p) {
		image = ImageUtil.getImage(this.getClass().getResourceAsStream("/boss.png"));
		width = image.getWidth();
		height = image.getHeight();

		// 从左方正中出现
		this.p = p;
		x = -width;
		y = p.getHeight() / 2 - height;

		score = Config.AWARD_BOSS; // 被击杀后，英雄机获得的分数
	}

	// 在限定范围内飞行
	void step() {
		switch (directX) {
		case LEFT:
			x -= speedX;
			if (x <= Config.X_LOWER)
				directX = RIGHT;
			break;
		case RIGHT:
			x += speedX;
			if (x >= Config.X_UPPER - width)
				directX = LEFT;
		}

		switch (directY) {
		case UP:
			y -= speedY;
			if (y <= 0)
				directY = DOWN;
			break;
		case DOWN:
			y += speedY;
			if (y >= p.getHeight() - height)
				directY = UP;
		}
	}

	// BOSS不会越界
	boolean outOfBounds() {
		return false;
	}

	// 射击
	List<Bullet> shoot() {
		List<Bullet> bullets = new ArrayList<Bullet>();
		int unitHeight = height / (fire + 1);
		for (int i = 0; i < fire; i++) {
			Bullet bullet = new Bullet(p, Bullet.RIGHT, x + width + 15, y + unitHeight
					* (i + 1) + 1);
			bullets.add(bullet);
		}
		return bullets;
	}

}
