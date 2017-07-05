package com.tarena;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

public abstract class Flying {
	static final Random RANDOM = new Random();

	// 载入图片
	BufferedImage image;
	int width;
	int height;

	// 当前坐标
	JPanel p;
	int x;
	int y;

	// 分数
	int score;

	abstract void step();

	abstract boolean outOfBounds();

	// 撞击判定
	boolean hit(Flying flying) {
		int x1 = flying.x - width;
		int x2 = flying.x + flying.width;
		int y1 = flying.y - height;
		int y2 = flying.y + flying.height;
		if (x1 < x && x < x2 && y1 < y && y < y2)
			return true;
		return false;
	}

}
