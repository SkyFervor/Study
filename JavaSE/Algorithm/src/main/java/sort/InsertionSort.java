package sort;

import java.util.*;

public class InsertionSort {

	public static int[] sort(int[] arr) {
		if (null == arr || 1 >= arr.length) {
			return arr;
		}
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (arr[mid] <= temp) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			for (int j = i - 1; j > high; j--) {
				arr[j + 1] = arr[j];
			}
			arr[high + 1] = temp;
		}
		return arr;
	}

	public static <T> void insertionSort(List<T> arr, Comparator<T> comparator) {
		if (arr == null || arr.size() <= 1 || comparator == null) {
			return;
		}

		for (int i = 1; i < arr.size(); i++) {
			T val = arr.get(i);
			int j = i - 1;
			while (j >= 0 && comparator.compare(arr.get(j), val) > 0) {
				arr.set(j + 1, arr.get(j));
				j--;
			}
			arr.set(j + 1, val);
		}
	}

	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			T val = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(val) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}
	}

	public static void recursiveInsertionSort(int[] arr, int n) {
		if (n > 0) {
			recursiveInsertionSort(arr, n - 1);
			int val = arr[n];
			int i = n - 1;
			while (i >= 0 && arr[i] > val) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = val;
		}
	}

	public static void reversedRecursiveInsertionSort(int[] arr, int m) {
		if (m < arr.length) {
			int val = arr[m];
			int i = m - 1;
			while (i >= 0 && arr[i] > val) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = val;
			reversedRecursiveInsertionSort(arr, m + 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {9, 8 ,8};
		System.out.println(Arrays.toString(sort(arr)));

		Random random = new Random();
		List<Integer> arr0 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr0.add(random.nextInt(31));
		}
		arr0.sort(Comparator.comparing(t -> t));
		//insertionSort(arr0, Comparator.comparingInt(t -> t));
		System.out.println(arr0);

		Integer[] arr1 = new Integer[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		insertionSort(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		recursiveInsertionSort(arr2, arr2.length - 1);
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = new int[]{9, 8, 7, 6, 5, 5, 4, 3, 3, 3, 2, 1};
		reversedRecursiveInsertionSort(arr3, 1);
		System.out.println(Arrays.toString(arr3));
	}
}
