package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		fun1();
		fun2();
	}

	/**
	 * 各种Set的特性
	 */
	public static void fun1() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(3);
		set1.add(-10);
		set1.add(1);
		System.out.println(set1);

		Set<String> set2 = new LinkedHashSet<String>();
		set2.add("123");
		set2.add("12");
		set2.add("1");
		System.out.println(set2);

		Set<String> set3 = new TreeSet<String>(set2);
		System.out.println(set3);

		TreeSet<Integer> set4 = new TreeSet<Integer>();
		set4.add(5);
		set4.add(3);
		set4.add(4);
		set4.add(1);
		set4.add(2);
		System.out.println(set4);
	}

	/**
	 * TreeMap和TreeSet要求存放的元素所属类必须实现Comparable接口
	 */
	public static void fun2() {
		class MyClass {
		}

		TreeSet<MyClass> set = new TreeSet<MyClass>();
		MyClass obj = new MyClass();
		set.add(obj); // 报错
	}
}
