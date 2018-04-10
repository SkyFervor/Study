package sort;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int i = low;
			int val = arr[high];
			for (int j = low; j < high; j++) {
				if (arr[j] <= val) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					i++;
				}
			}
			arr[high] = arr[i];
			arr[i] = val;

			quickSort(arr, low, i - 1);
			quickSort(arr, i + 1, high);
		}
	}

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

		int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		quickSort(arr1, 0, arr1.length - 1);
		System.out.println(Arrays.toString(arr1));
	}
}
