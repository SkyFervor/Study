package com.tarena;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Bee extends Flying {
	// 随机确定起始飞行方向
	public static final int UP = 0;
	public static final int DOWN = 1;
	int direct = RANDOM.nextInt(2);

	// 设置两个方向上的飞行速度
	int speedX = Config.SPEED_BEE_X;
	int speedY = Config.SPEED_BEE_Y;

	// 随机确定被击杀后，英雄机是获得生命值还是火力值
	public static final int LIFE_AWARD = 0;
	public static final int FIRE_AWARD = 1;
	int awardType = RANDOM.nextInt(2);

	Bee(JPanel p) {
		image = ImageUtil.getImage(this.getClass().getResourceAsStream("/bee.png"));
		width = image.getWidth();
		height = image.getHeight();

		// 随机从左方出现
		this.p = p;
		y = -width;
		y = RANDOM.nextInt(p.getHeight() - height);

		score = Config.AWARD_BEE; // 被击杀后，英雄机获得的分数
	}

	// 以折线形式从左向右飞行
	void step() {
		switch (direct) {
		case UP:
			y -= speedY;
			if (y <= 0)
				direct = DOWN;
			break;
		case DOWN:
			y += speedY;
			if (y >= p.getHeight() - height)
				direct = UP;
		}
		x += speedX;
	}

	// 判断是否已在右边越界
	boolean outOfBounds() {
		if (x >= p.getWidth())
			return true;
		return false;
	}

}
