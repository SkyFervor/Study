package clone;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a1 = new A();
		A a2 = (A) a1.clone();
		a1.value = 2;
		System.out.println(a1.value == a2.value);

		System.out.println();

		B b1 = new B();
		B b2 = (B) b1.clone();
		b1.value = 2;
		b1.a.value = 2;
		System.out.println(b1.value == b2.value);
		System.out.println(b1.a.value == b2.a.value); // 浅拷贝，只复制了a的引用

		System.out.println();

		C c1 = new C();
		C c2 = (C) c1.clone();
		c1.value = 2;
		c1.a.value = 2;
		System.out.println(c1.value == c2.value);
		System.out.println(c1.a.value == c2.a.value); // 深拷贝
	}
}

class A implements Cloneable {
	int value = 1;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class B implements Cloneable {
	int value = 1;
	A a = new A();

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class C implements Cloneable {
	int value = 1;
	A a = new A();

	@Override
	public Object clone() throws CloneNotSupportedException {
		C obj = (C) super.clone();
		obj.a = (A) a.clone();
		return obj;
	}
}