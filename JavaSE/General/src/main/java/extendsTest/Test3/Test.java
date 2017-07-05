package extendsTest.Test3;

/**
 * Created by skyfervor
 * 2017/05/16 18:18
 */
public class Test {
	public static void main(String[] args) {
		Super obj = new Child();
		System.out.println(obj.getObj());
	}
}

class Super {
	public Super get() {
		return new Super();
	}

	public Object getObj() {
		return get();
	}
}

class Child extends Super {
	@Override
	public Child get() {
		return new Child();
	}

	@Override
	public Child getObj() {
		System.out.println(super.getObj());
		return get();
	}
}
