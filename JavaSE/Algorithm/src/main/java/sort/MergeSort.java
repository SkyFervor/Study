package sort;

import java.util.Arrays;

/**
 * 二路归并排序
 * 时间效率O(nlogn)，空间效率O(n)
 * 稳定，算法较复杂
 */
public class MergeSort {
	public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		mergeSort(arr, tmp, start, mid);
		mergeSort(arr, tmp, mid + 1, end);

		int index = start;
		int i = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j])
				tmp[index++] = arr[i++];
			else
				tmp[index++] = arr[j++];
		}

		while (i <= mid)
			tmp[index++] = arr[i++];
		while (j <= end)
			tmp[index++] = arr[j++];

		for (int k = start; k <= end; k++)
			arr[k] = tmp[k];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
