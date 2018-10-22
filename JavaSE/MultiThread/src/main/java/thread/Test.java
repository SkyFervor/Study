package thread;

public class Test {
	public static void main(String[] args) {
		Child child = new Child();
		Runnable runnable = child::fun;
		new Thread(runnable).start();
		new Thread(runnable).start();
	}

}

class Parent {
	private String name = "Parent";

	public synchronized void fun() {
		System.out.println(this.name);
	}
}

class Child extends Parent {
	private String name = "Child";

	@Override
	public void fun() {
		System.out.println(this.name);
		super.fun();
	}
}