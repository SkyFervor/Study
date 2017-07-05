package com.tarena;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.tarena.util.ImageUtil;

public class Hero extends Flying {
	BufferedImage images[] = { ImageUtil.getImage("res/hero0.png"),
			ImageUtil.getImage("res/hero1.png") };

	int life = Constant.INITIAL_LIFE;
	int fire = Constant.INITIAL_FIRE;

	Hero(int x, int y) {
		image = images[0];
		width = image.getWidth();
		height = image.getHeight();

		this.x = x;
		this.y = y;

		score = Constant.INITIAL_SCORE;
	}

	int stepIndex = 0;

	@Override
	void step() {
		image = images[stepIndex++ / 10 % images.length];
	}

	@Override
	boolean outOfBounds() {
		return false;
	}

	void moveTo(int x, int y) {
		this.x = x - width / 2;
		this.y = y - height / 2;
	}

	List<Bullet> shoot() {
		fire = fire > Constant.MAX_FIRE ? Constant.MAX_FIRE : fire;

		List<Bullet> bullets = new ArrayList<Bullet>();
		int unitWidth = width / (fire + 1);
		for (int i = 0; i < fire; i++) {
			Bullet bullet = new Bullet(x + unitWidth * (i + 1) + 1, y - 15);
			bullets.add(bullet);
		}
		return bullets;
	}

}
