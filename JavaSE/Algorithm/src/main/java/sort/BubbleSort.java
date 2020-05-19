package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					arr[j] += arr[j - 1];
					arr[j - 1] = arr[j] - arr[j - 1];
					arr[j] -= arr[j - 1];
				}
			}
		}
	}

	public static void recursiveBubbleSort(int[] arr, int m) {
		if (m < arr.length - 1) {
			for (int i = arr.length - 1; i > m; i--) {
				if (arr[i] < arr[i - 1]) {
					arr[i] += arr[i - 1];
					arr[i - 1] = arr[i] - arr[i - 1];
					arr[i] -= arr[i - 1];
				}
			}
			recursiveBubbleSort(arr, m + 1);
		}
	}

	public static void improvedBubbleSort(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (!flag) {
				return;
			}
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					arr[j] += arr[j - 1];
					arr[j - 1] = arr[j] - arr[j - 1];
					arr[j] -= arr[j - 1];
					flag = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		bubbleSort(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		recursiveBubbleSort(arr2, 0);
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		improvedBubbleSort(arr3);
		System.out.println(Arrays.toString(arr3));
	}
}
