package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		testLinkedList();
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
		for (Integer i : list) {
			System.out.println(i.intValue());
		}
	}
}
