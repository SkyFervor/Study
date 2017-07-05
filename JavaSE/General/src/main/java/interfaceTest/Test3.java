package interfaceTest;

/**
 * Created by skyfervor
 * 2017/03/28 20:46
 */
public class Test3 {
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.get());
	}
}

interface SuperSuper {
	default String get() {
		return "SuperSuper";
	}
}

interface Super1 extends SuperSuper {
	default String get() {
		return "Super1";
	}
}

class Super2 implements SuperSuper {
	@Override
	public String get() {
		return "Super2";
	}
}

class Child extends Super2 implements Super1 {
}