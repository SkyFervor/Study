package nullPointer;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		String s1 = null;
		String s2 = "test" + s1;
		System.out.println(s2);

		String s3 = "test";
		String s4 = s3 + s1;
		System.out.println(s4);
	}

	public static void test2() {
		if ((Integer) null > 1) {
		}
/*
		if ((Integer) null > 1) {
			System.out.println("1");
		}
		*/
	}

}
