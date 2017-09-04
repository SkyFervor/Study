package sort;

import java.util.*;

public class SelectionSort {

	public static <T> void selectionSort(List<T> list, Comparator<T> comparator) {
		if (list == null || list.size() <= 1) {
			return;
		}
		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (comparator.compare(list.get(j), list.get(min)) < 0) {
					min = j;
				}
			}
			if (min != i) {
				T t = list.get(i);
				list.set(i, list.get(min));
				list.set(min, t);
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int val = arr[min];
				arr[min] = arr[i];
				arr[i] = val;
			}
		}
	}

	public static void recursiveSelectionSort(int[] arr, int m) {
		if (m < arr.length - 1) {
			int min = m;
			for (int i = m + 1; i < arr.length; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			if (min != m) {
				arr[min] += arr[m];
				arr[m] = arr[min] - arr[m];
				arr[min] -= arr[m];
			}
			recursiveSelectionSort(arr, m + 1);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		selectionSort(list, Comparator.comparing(t -> t));
		System.out.println(list);

		int[] arr1 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		selectionSort(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		recursiveSelectionSort(arr2, 0);
		System.out.println(Arrays.toString(arr2));
	}
}
