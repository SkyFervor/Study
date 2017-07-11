package innerClass;

public class Outer {

	private int out_a = 1;
	private static String out_b = "2";

	// 普通内部类定义
	class Inner {
		static final int a = 0;
		int b;

		public int get_a() {
			return out_a; // 能访问 外部类 的 实例域
		}

		public String get_b() {
			return out_b; // 能访问 外部类 的 静态域
		}
	}

	// 静态内部类定义
	static class StaticInner {
		static int a;
		int b;

		/*
		public int get_a() {
			return out_a; //不能访问 外部类 的 实例域
		}
		*/

		public static String get_b() {
			return out_b; // 能访问 外部类 的 静态域
		}
	}

}

abstract class aaa extends Outer {
	int a;
}

class bbb extends aaa {

}
