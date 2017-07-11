package extendsTest;

public class Test {

	public static void main(String[] args) {

		// 超类对象
		Super superObj = new Super();
		System.out.println(superObj.a);
		System.out.println(superObj.getA());

		System.out.println();

		// 子类对象
		Child childObj = new Child();
		System.out.println(childObj.a);
		System.out.println(childObj.getA());

		System.out.println();

		// 对象置换
		Super s_child = new Child();
		System.out.println(s_child.a); // 访问到的是超类的域
		System.out.println(s_child.getA()); // 可以调用到子类的 重写方法
		// System.out.println(s_child.b); // 不能直接访问到子类的 域
		// System.out.println(s_child.getB()); // 不能调用到子类的 特有方法
		// System.out.println(s_child.getA(1)); // 不能调用到子类的 重载方法

		System.out.println();

		// 根据申明类型调用
		System.out.println(get(superObj));
		System.out.println(get(s_child));
		System.out.println(get(childObj));
		// 继承链最近的向上转型
		ChildOfChild cc = new ChildOfChild();
		System.out.println(get(cc));

		System.out.println();

		// 无论方法申明在哪里，只要没加super就按实际类型调用重写方法
		System.out.println(superObj.testEntrance());
		System.out.println(childObj.testEntrance());
		System.out.println(s_child.testEntrance());

	}

	public static int get(Super s) {
		return 1;
	}

	public static int get(Child c) {
		return 2;
	}
}


class Super {

	int a = 1;
	static int b = 2;

	public int getA() {
		return a;
	}

	public int test() {
		return 1;
	}

	public int testEntrance() {
		return test();
	}
}

class Child extends Super {
	int a = 2;
	int b = 3;

	@Override
	public int getA() {
		return a;
	}

	public int getA(int a) {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public int test() {
		return 2;
	}
}

class ChildOfChild extends Child {
}
