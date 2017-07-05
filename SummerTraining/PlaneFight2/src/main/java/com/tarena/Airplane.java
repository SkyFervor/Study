package com.tarena;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Airplane extends Flying {
	int speed = Config.SPEED_AIR; // 设置飞行速度

	Airplane(JPanel p) {
		image = ImageUtil.getImage(this.getClass().getResourceAsStream("/airplane.png"));
		width = image.getWidth();
		height = image.getHeight();

		// 随机从左方出现
		this.p = p;
		x = -width;
		y = RANDOM.nextInt(p.getHeight() - height);

		score = RANDOM.nextInt(Config.AWARD_AIR) + 1; // 随机确定被击杀后，英雄机获得的分数
	}

	// 水平向右飞行
	void step() {
		x += speed;
	}

	// 判断是否已越界
	boolean outOfBounds() {
		if (x >= p.getWidth())
			return true;
		return false;
	}

}
