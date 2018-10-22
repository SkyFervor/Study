package collection;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class RemoveTest {

	public static void main(String[] args) {
		test1();
		System.out.println();
		test2();
	}

	private static void test1() {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		Set<Integer> set2 = new HashSet<>();
		set2.add(4);
		set2.add(5);

		System.out.println(set1.removeAll(set2));
		System.out.println(set1);
	}

	private static void test2() {
		Set<Integer> set = Sets.newHashSet(1);
		System.out.println(set.remove(2));
	}
}
