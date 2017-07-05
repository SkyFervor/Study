package com.tarena;

import com.tarena.util.ImageUtil;

public class Bullet extends Flying {
	int speed = Constant.SPEED_BULLET;

	Bullet(int x, int y) {
		image = ImageUtil.getImage("res/bullet.png");
		width = image.getWidth();
		height = image.getHeight();

		this.x = x - width / 2;
		this.y = y;
	}

	@Override
	void step() {
		y -= speed;
	}

	@Override
	boolean outOfBounds() {
		if (y <= -height)
			return true;
		return false;
	}

}
