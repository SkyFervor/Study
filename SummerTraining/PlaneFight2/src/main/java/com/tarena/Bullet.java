package com.tarena;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Bullet extends Flying {
	// 子弹方向
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	int direct;
	// 载入图片
	BufferedImage[] images = {
			ImageUtil.getImage(this.getClass().getResourceAsStream("/bullet_left.png")),
			ImageUtil.getImage(this.getClass().getResourceAsStream("/bullet_right.png")) };

	int speed = Config.SPEED_BULLET; // 设置飞行速度

	Bullet(JPanel p, int direct, int x, int y) {
		image = images[direct < 0 ? 0 : 1];
		width = image.getWidth();
		height = image.getHeight();

		this.direct = direct;

		// 以传入的值为基准调整坐标
		this.p = p;
		this.x = x;
		this.y = y - height / 2;

	}

	// 水平飞行
	void step() {
		x = x + speed * direct;
	}

	// 判断是否越界
	boolean outOfBounds() {
		if (direct == LEFT && x <= -width)
			return true;
		else if (direct == RIGHT && x >= p.getWidth())
			return true;
		return false;
	}

}
