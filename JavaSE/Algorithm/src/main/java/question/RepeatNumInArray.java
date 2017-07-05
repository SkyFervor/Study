package question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1范围内
 * 找到数组中的重复数字
 */
public class RepeatNumInArray {
	// 时间复杂度O(n)，空间复杂度O(1)算法，必须满足元素大小在0到n-1
	public static TreeSet<Integer> repeatNum1(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();

		if (arr == null || arr.length == 0)
			return set;

		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int index = arr[i];
			if (index >= length)
				index -= length;

			if (arr[index] >= length)
				set.add(index);
			else
				arr[index] += length;
		}
		return set;
	}

	// 时间复杂度O(n)，空间复杂度O(n)的一般算法
	public static TreeSet<Integer> repeatNum2(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();
		if (arr == null || arr.length == 0)
			return set;

		int length = arr.length;
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < length; i++) {
			int n = arr[i];
			if (hash.contains(n))
				set.add(n);
			else
				hash.add(n);
		}
		return set;
	}

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(repeatNum1(Arrays.copyOf(arr1, arr1.length)));
		System.out.println(repeatNum2(arr1));
	}
}
