package passByValue;


public class Main {

	public static void main(String[] args) {
		// int
		int a = 1;
		System.out.println(a);
		passInt(a);
		System.out.println(a); // 不变

		// Integer
		Integer b = 1;
		System.out.println("\n" + b);
		passInteger(b);
		System.out.println(b);// 不变

		// String
		String c = "1";
		System.out.println("\n" + c);
		passString(c);
		System.out.println(c); // 不变

		// String[]
		String[] d = new String[] { "1" };
		System.out.println("\n" + d[0]);
		passStringArray(d);
		System.out.println(d[0]); // 改变

		// 自定义类E
		E e1 = new E(1);
		System.out.println("\n" + e1.value);
		passE(e1);
		System.out.println(e1.value); // 改变
	}

	public static void passInt(int v) {
		v = 2;
	}

	public static void passInteger(Integer v) {
		v = 2;
	}

	public static void passString(String v) {
		v = "2";
	}

	public static void passStringArray(String[] v) {
		v[0] = "2";
	}

	public static void passE(E e) {
		e.value = 2;
	}

	static class E {
		public int value;

		public E(int v) {
			this.value = v;
		}
	}

}
