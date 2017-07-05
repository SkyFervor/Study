package interfaceTest;

import java.util.List;

/**
 * Created by skyfervor
 * 2017/03/28 20:52
 */
public class Test4 {

	interface SuperSuper {
		default String get() {
			return "SuperSuper";
		}
	}

	interface Super1 extends SuperSuper {
	}

	interface Super2 extends SuperSuper {
		@Override
		default String get() {
			return "Super2";
		}
	}

	static class Child implements Super1, Super2 {
	}

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.get());

	}

}


