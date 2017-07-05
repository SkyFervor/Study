package com.tarena;

public class Config {
	/*生命值*/
	public static final int LIFE_MAX = 5; // 最大生命值
	public static final int LIFE_HERO = 3; // 起始生命值
	public static final int LIFE_BOSS = 50; // Boss生命值

	/*火力值*/
	public static final int FIRE_MAX = 3; // 最大火力值
	public static final int FIRE_HERO = 1; // 英雄机火力值
	public static final int FIRE_BOSS = 1; // Boss火力值

	/*入场、射击速度*/
	public static final int ENTER_HERO_SHOOT = 25; // 英雄机射击速度
	public static final int ENTER_FLYING = 30; // 控制敌机的出现速度
	public static final int ENTER_BOSS_SHOOT = 60; // Boss射击速度

	/*飞行速度*/
	public static final int SPEED_AIR = 5; // 敌机飞行速度
	public static final int SPEED_BEE_X = 3; // 蜜蜂在x方向上的速度
	public static final int SPEED_BEE_Y = 6; // 蜜蜂在y方向上的速度
	public static final int SPEED_BULLET = 3; // 子弹飞行速度
	public static final int SPEED_BOSS_X = 2; // Boss在x方向上的速度
	public static final int SPEED_BOSS_Y = 3; // Boss在y方向上的速度

	/*得分*/
	public static final int INIT_SCORE = 0; // 起始分数

	public static final int AWARD_AIR = 1000; // 击中敌机得分
	public static final int AWARD_BEE = 1; // 击中蜜蜂得分
	public static final int AWARD_BOSS = 5000; // 击毁Boss得分

	public static final int PROMOTION_SCORE = 20000; // 晋级分数，Boss出现

	/*Boss移动范围*/
	public static final int X_UPPER = 300;
	public static final int X_LOWER = 0;
}
