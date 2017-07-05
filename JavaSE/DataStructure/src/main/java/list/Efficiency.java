package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Efficiency {
	public static final int N = 50000;

	public static List<Integer> values;

	static {
		Integer vals[] = new Integer[N];

		Random r = new Random();

		for (int i = 0, currval = 0; i < N; i++) {
			vals[i] = new Integer(currval);
			currval += r.nextInt(100) + 1;
		}

		values = Arrays.asList(vals);
	}

	public static void main(String args[]) {
		fun1();
	}

	/**
	 * 测试ArrayList和LinkedList的二分查找效率
	 */
	public static void fun1() {
		List<Integer> array = new ArrayList<Integer>(values);
		List<Integer> linked = new LinkedList<Integer>(values);
		System.out.println("ArrayList消耗时间：\t" + binarySearchTest(array));
		System.out.println("LinkedList消耗时间：\t" + binarySearchTest(linked));
	}

	public static long binarySearchTest(List<Integer> lst) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			int index = Collections.binarySearch(lst, values.get(i));
			if (index != i)
				System.out.println("***错误***");
		}
		return System.currentTimeMillis() - start;
	}
}
