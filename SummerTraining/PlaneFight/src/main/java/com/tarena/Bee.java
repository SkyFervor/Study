package com.tarena;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Bee extends Flying {
	int speedX = Constant.SPEED_BEE_X;
	int speedY = Constant.SPEED_BEE_Y;
	int direct = RANDOM.nextInt(2);

	public static final int LEFT = 0;
	public static final int RIGHT = 1;

	public static final int LIFE_AWARD = 0;
	public static final int FIRE_AWARD = 1;
	int awardType = RANDOM.nextInt(2);

	Bee(JPanel p) {
		image = ImageUtil.getImage("res/bee.png");
		width = image.getWidth();
		height = image.getHeight();

		this.p = p;
		x = RANDOM.nextInt(p.getWidth() - width);
		y = -height;

		score = Constant.AWARD_BEE;
	}

	@Override
	void step() {
		switch (direct) {
		case LEFT:
			x -= speedX;
			if (x <= 0)
				direct = RIGHT;
			break;
		case RIGHT:
			x += speedY;
			if (x >= p.getWidth() - width)
				direct = LEFT;
		}
		y += speedY;
	}

	@Override
	boolean outOfBounds() {
		if (y >= p.getHeight())
			return true;
		return false;
	}

}
