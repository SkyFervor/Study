package initialization;

/**
 * Created by skyfervor
 * 2017/04/17 21:05
 */
public class Test2 {
	public static void main(String[] args) {
		staticFun();
	}

	static Test2 st = new Test2();

	static {
		System.out.println(1);
	}

	{
		System.out.println(2);
	}

	Test2() {
		System.out.println(3);
		System.out.println("a=" + a + " b=" + b);
	}

	public static void staticFun() {
		System.out.println(4);
	}

	int a = 110;
	static int b = 112;
}
