package com.tarena;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.tarena.util.ImageUtil;

public class Hero extends Flying {
	// 载入图片
	BufferedImage images[] = {
			ImageUtil.getImage(this.getClass().getResourceAsStream("/hero0.png")),
			ImageUtil.getImage(this.getClass().getResourceAsStream("/hero1.png")) };

	int life = Config.LIFE_HERO; // 初始化生命值
	int fire = Config.FIRE_HERO; // 初始化火力

	Hero(JPanel p, int x, int y) {
		image = images[0];
		width = image.getWidth();
		height = image.getHeight();

		// 用传入的值作为起始坐标
		this.p = p;
		this.x = x;
		this.y = y;

		score = Config.INIT_SCORE; // 初始化得分
	}

	int stepIndex = 0;

	// 循环绘制图片，体现飞行效果
	void step() {
		image = images[stepIndex++ / 30 % images.length];
	}

	// 英雄机不会越界
	boolean outOfBounds() {
		return false;
	}

	// 射击
	List<Bullet> shoot() {
		List<Bullet> bullets = new ArrayList<Bullet>();
		int unitHeight = height / (fire + 1);
		for (int i = 0; i < fire; i++) {
			Bullet bullet = new Bullet(p, Bullet.LEFT, x - 15, y + unitHeight * (i + 1) + 1);
			bullets.add(bullet);
		}
		return bullets;
	}

	// 以传入的坐标作为中心进行移动
	void moveTo(int x, int y) {
		this.x = x - width / 2;
		this.y = y - height / 2;
	}

}
