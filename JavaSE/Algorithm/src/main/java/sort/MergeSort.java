package sort;

import java.util.Arrays;

/**
 * 二路归并排序
 * 时间效率O(nlogn)，空间效率O(n)
 * 稳定，算法较复杂
 */
public class MergeSort {

	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			int[] temp = new int[high - low + 1];
			int i = low;
			int j = mid + 1;
			int k = 0;
			while (i <= mid && j <= high) {
				if (arr[i] <= arr[j]) {
					temp[k++] = arr[i++];
				} else {
					temp[k++] = arr[j++];
				}
			}
			while (i <= mid) {
				temp[k++] = arr[i++];
			}
			while (j <= high) {
				temp[k++] = arr[j++];
			}
			System.arraycopy(temp, 0, arr, low, k);
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		mergeSort(arr1, 0, arr1.length - 1);
		System.out.println(Arrays.toString(arr1));
	}
}
