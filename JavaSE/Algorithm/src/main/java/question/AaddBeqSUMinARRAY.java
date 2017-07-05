package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组中找和为sum的两个数
 */
public class AaddBeqSUMinARRAY {

	/**
	 * 在一个乱序数组中查找
	 */
	public static void fun1() {
		int sum = 100;
		int[] a = { 5, 46, 27, 93, 31, 54, 28, 66 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				System.out.println(a[i] + " " + a[map.get(a[i])]);
				break;
			}
			map.put(sum - a[i], i);
		}
	}

	/**
	 * 在两个乱序数组中分别找一个
	 */
	public static void fun2() {
		int sum = 100;
		int[] a = { 5, 46, 27, 93, 31, 54, 28, 66 };
		int[] b = { 5, 46, 27, 93, 31, 54, 28, 66 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++)
			map.put(sum - a[i], i);

		for (int i = 0; i < b.length; i++) {
			if (map.containsKey(b[i])) {
				System.out.println(a[map.get(b[i])] + " " + b[i]);
				break;
			}
		}
	}

	/**
	 * 在一个有序数组中查找
	 */
	public static void fun3() {
		int sum = 100;
		int[] a = { 5, 46, 27, 93, 31, 54, 28, 66 };
		Arrays.sort(a);

		int head = 0, tail = a.length - 1;
		while (head < tail) {
			int temp = a[head] + a[tail];
			if (temp == sum) {
				System.out.println(a[head] + " " + a[tail]);
				break;
			}

			if (temp < sum)
				head++;
			else
				tail--;
		}
	}

	public static void main(String[] args) {
		fun1();
		fun2();
		fun3();
	}
}
