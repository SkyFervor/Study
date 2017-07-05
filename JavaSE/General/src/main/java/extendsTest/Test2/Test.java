package extendsTest.Test2;

/**
 * Created by skyfervor
 * 2017/05/10 11:40
 */
public class Test {
	public static void main(String[] args) {
		Super obj = new Child();
	}
}

class Super {
	public Super() {
		this.print();
	}

	public Super print() {
		System.out.println("Super");
		return null;
	}

}

class Child extends Super {
	// 重写，可协变返回类型
	public Child print() {
		System.out.println("Child");
		return null;
	}

}

