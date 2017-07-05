package parameterMatching;

public class Test {
	private static Test test = new Test();

	public static Test getInstance() {
		return test;
	}

	public void test(byte value) {
		System.out.println("byte: " + value);
	}

	public void test(Integer value) {
		System.out.println("Integer: " + value);
	}

	public void test(long value) {
		System.out.println("long: " + value);
	}

	public void test(Long value) {
		System.out.println("Long: " + value);
	}

	public static void main(String[] args) {
		Byte i = 1;
		Integer m = 1;
		int n = 1;
		Long x = 1L;
		long y = 1L;

		getInstance().test(i);
		getInstance().test(m);
		getInstance().test(n);
		getInstance().test(x);
		getInstance().test(y);
	}
}
