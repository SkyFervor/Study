package com.tarena;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Airplane extends Flying {
	int speed = Constant.SPEED_AIR;

	Airplane(JPanel p) {
		image = ImageUtil.getImage("res/airplane.png");
		width = image.getWidth();
		height = image.getHeight();

		this.p = p;
		x = RANDOM.nextInt(p.getWidth() - width);
		y = -height;

		score = RANDOM.nextInt(Constant.AWARD_AIR) + 1;
	}

	@Override
	void step() {
		y += speed;
	}

	@Override
	boolean outOfBounds() {
		if (y >= p.getHeight())
			return true;
		return false;
	}

}
