package autoboxing;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	public static void test1() {
		Integer a = new Integer(100);
		Integer b = new Integer(100);
		System.out.println(a == b); // false
	}

	public static void test2() {
		Integer a = 1024;
		int b = 1024;
		System.out.println(a == b); // true
	}

	public static void test3() {
		Integer a = 127;
		Integer b = 127;
		System.out.println(a == b); // true

		Integer c = -128;
		Integer d = -128;
		System.out.println(c == d); // true
	}

	public static void test4() {
		Integer a = 128;
		Integer b = 128;
		System.out.println(a == b); // false

		Integer c = -129;
		Integer d = -129;
		System.out.println(c == d); // false
	}

}
