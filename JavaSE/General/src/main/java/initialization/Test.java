package initialization;

/**
 * 观察类的初始化过程
 */
public class Test extends Super{
	public static int k = 0;
	public static Test t1 = new Test("t1");
	public static Test t2 = new Test("t2");
	public static int i = print("i");
	public static int n = 99;
	public int j = print("j");
	{
		print("构造块");
	}
	static {
		print("静态块");
	}

	public Test(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
		++i;
		++n;
	}

	public Test(int i) {
		super(i);
		System.out.println("Test:" + i);
	}

	public static int print(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
		++n;
		return ++i;
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Test t1 = new Test("init");
		Test t2 = new Test(1);
	}
}

class Super {

	public Super() {

	}

	public Super(int i) {
		System.out.println("Super:" + i);
	}
}