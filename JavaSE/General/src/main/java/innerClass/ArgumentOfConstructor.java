package innerClass;

import reflectionTools.ClassAnalyzer;

public class ArgumentOfConstructor {

	public static void main(String[] args) {
		// 根据 超类构造器 构造匿名内部类对象
		Super s = new Super(1) {
			// 构造块，调用类中的方法
			{
				setI(-1);
			}

			// getI()的重写
			public int getI() {
				return i;
			}

			// getI()的重载
			@SuppressWarnings("unused")
			public int getI(int j) {
				return j;
			}
		};

		System.out.println(s.getI());
		// System.out.println(s.getI(2)); // s是进行了 对象置换 的子类对象，调用不到子类中的 非重写方法

		System.out.println(s.getClass().getName());

		System.out.println(ClassAnalyzer.analyze(s.getClass()));
	}

}

class Super {

	int i;

	public Super(int i) {
		setI(i);
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

}
