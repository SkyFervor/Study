package interfaceTest;

public class Test {
	public static void main(String[] args) {
		Inter inter = new Class1();
		System.out.println(inter.get());
		// inter.print(); // 不能调用
	}
}

interface Inter {
	int get();
}

class Class1 implements Inter {
	@Override
	public int get() {
		return 1;
	}

	public void print() {
		System.out.println("set()");
	}
}

class Class2 {
	public void get() {
		System.out.println("Class2.get()");
	}
}

// 方法签名一致但是返回类型不符合接口规范
// class Class3 extends Class2 implements Inter {}
