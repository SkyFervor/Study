package question;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray {
	/**
	 * 不改变原有奇数（偶数）间的排序
	 * 每次找到下一个奇数，利用类似冒泡的算法将奇数移到已排序的奇数的最后面
	 * 
	 * @param arr
	 */
	public static void reOrderArrayWithNoChange(int[] arr) {
		if (arr.length == 0)
			return;

		int i = 0, j = 0;
		while (true) {
			while (j < arr.length && arr[j] % 2 == 0)
				j++;
			if (j == arr.length)
				break;
			while (i < j && arr[i] % 2 != 0)
				i++;

			if (i != j) {
				int tmp = arr[j];
				for (int k = j; k > i; k--)
					arr[k] = arr[k - 1];
				arr[i] = tmp;
			}
			i++;
			j++;
		}
	}

	/**
	 * 一般解法
	 * 不考虑原有奇数（偶数）间的排序
	 * 
	 * @param arr
	 */
	public static void reOrderArray(int[] arr) {
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			while (i < j && arr[i] % 2 != 0)
				i++;
			while (i < j && arr[j] % 2 == 0)
				j--;

			if (i == j)
				break;

			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;

			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		reOrderArrayWithNoChange(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		reOrderArray(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
