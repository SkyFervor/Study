package innerClass;

public class Outer {

	private static String out_a = "2"; // 内部类 访问 外部类的私有域：通过编译时在外部类添加额外的 静态访问方法
	private int out_b = 1;

	// 私有内部类
	private class PrivateInner {
	}

	// 普通内部类
	class Inner {
		static final int a = 0; // 静态域 必须是 final
		int b;

		public String get_a() {
			return out_a; // 能访问 外部类 的 静态域
		}

		public int get_b() {
			return out_b; // 能访问 外部类 的 实例域
		}

		/*
		public static int get() { // 不能有 静态域
			return 0;
		}
		 */
	}

	// 静态内部类
	static class StaticInner {
		static int a;
		int b;

		/*
		public int get_a() {
			return out_a; //不能访问 外部类 的 实例域
		}
		*/

		public static String get_a() {
			return out_a; // 能访问 外部类 的 静态域
		}
	}

}
