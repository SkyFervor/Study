package equals;

import reflectionTools.ObjectAnalyzer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "1";
		String b = "1";
		String c = new String("1");
		String d = new String("1");
		String e = new String(a);
		String f = new String(a);

		System.out.println(a == b); // true
		System.out.println(a == c); // false
		System.out.println(a == e); // false
		System.out.println(a == "1"); // true
		System.out.println(c == d); // false
		System.out.println(c == e); // false
		System.out.println(c == "1"); // false
		System.out.println(e == f); // false
		System.out.println(e == "1"); // false

		System.out.println();

		String g = a;
		System.out.println(a == g); // true
		g += "2";
		System.out.println(a == g); // false

		System.out.println();

		Integer m = 127;
		Integer n = 127;
		Integer p = new Integer(127);
		Integer q = new Integer(127);
		System.out.println(m == n); // true
		System.out.println(m == p); // false
		System.out.println(m == 127); // true
		System.out.println(p == q); // false
		System.out.println(p == 127); // true
		Integer x = 128;
		Integer y = 128;
		System.out.println(x == y); // false
		System.out.println(x == 128); // true

		Integer m2 = -128;
		Integer n2 = -128;
		System.out.println(m2 == n2); // true

		Integer m3 = -129;
		Integer n3 = -129;
		System.out.println(m3 == n3); // false

		int[] ass = { 1, 2, 3, 4 };
		System.out.println(ObjectAnalyzer.analyze(ass));

		int xx = 8;
		int re = (xx & 0b1000) / 0b1000;
		System.out.println(re);
	}

}
