package overload;

/**
 * Created by skyfervor
 * 2017/03/28 16:34
 */
public class Test {
	private static Test instance = new Test();

	public static Test getInstance() {
		return instance;
	}

	public void run(Super obj) {
		System.out.println("run(Super): This is " + obj.get());
	}

	public void run(Child obj) {
		System.out.println("run(Child): This is " + obj.get());
	}

	public static void main(String[] args) {
		Super superObj = new Super();
		getInstance().run(superObj);

		System.out.println();

		Super childObj = new Child();
		getInstance().run(childObj);

		System.out.println();

		Child newChild = (Child) childObj;
		getInstance().run(newChild);
	}
}

class Super {
	public String get() {
		return "super";
	}
}

class Child extends Super {
	@Override
	public String get() {
		return "child";
	}
}
