package recursion;

/**
 * 数组中的逆序对数量
 * 逆序对：前面的一个数大于后面的一个数，则构成一对逆序对
 */
public class InversePairs {
	// 在归并排序过程中统计当前两个子数组的逆序对数量
	// 前面的子数组中的元素大于后面的子数组中的元素，则构成一个逆序对
	public static int mergeProcess(int[] arr, int[] tmp, int start, int end) {
		if (start >= end)
			return 0;

		int mid = (start + end) / 2;

		int count = mergeProcess(arr, tmp, start, mid);
		count += mergeProcess(arr, tmp, mid + 1, end);

		int index = end;
		int i = mid;
		int j = end;
		while (i >= start && j >= mid + 1) {
			if (arr[i] > arr[j]) {
				tmp[index--] = arr[i--];
				count += j - mid;
			} else
				tmp[index--] = arr[j--];
		}

		while (i >= start)
			tmp[index--] = arr[i--];
		while (j >= mid + 1)
			tmp[index--] = arr[j--];

		for (int k = start; k <= end; k++)
			arr[k] = tmp[k];

		return count;
	}

	public static void main(String[] args) {
		int[] arr1 = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		int[] tmp1 = new int[arr1.length];
		System.out.println(mergeProcess(arr1, tmp1, 0, arr1.length - 1));

		int[] arr2 = { 1, 2, 3, 4, 7, 6, 5 };
		int[] tmp2 = new int[arr2.length];
		System.out.println(mergeProcess(arr2, tmp2, 0, arr2.length - 1));
	}
}
