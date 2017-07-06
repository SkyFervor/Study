package list;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		testLinkedList();

		System.out.println();
		testArrayList();
	}

	public static void testLinkedList() {
		List<Integer> list = new LinkedList<>();
		list.add(null);
		list.add(null);
		System.out.println(list);
	}

	public static void testArrayList() {
		List<Integer> list = new ArrayList<>();
		list.add(null);
		list.add(null);
		System.out.println(list);
		for (Integer i : list) { // Exception
			System.out.println(i.intValue());
		}
	}
}
