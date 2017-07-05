package sort;

import java.util.Arrays;

public class QuickSort {
	public static void sort(int[] arr, int left, int right) {
		if (left >= right)
			return;

		int i = left, j = right;
		int tmp = arr[i];

		while (i != j) {
			while (j > i && arr[j] > tmp)
				j--;
			arr[i] = arr[j];

			while (i < j && arr[i] < tmp)
				i++;
			arr[j] = arr[i];
		}
		arr[i] = tmp;

		sort(arr, left, i - 1);
		sort(arr, i + 1, right);
	}

	public static void main(String[] args) {
		int[] nums = { 6, 8, 7, 9, 0, 1, 3, 2, 4, 5 };

		System.out.println(Arrays.toString(nums));
		sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
