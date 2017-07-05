package search;

/**
 * 二分查找/折半查找
 */
public class BinarySearch {
	public static int search(int[] arr, int x, int y, int v) {
		int m;// 1
		while (x <= y) {
			m = x + (y - x) / 2; // 2
			if (arr[m] == v)
				return m; // 3
			else if (arr[m] > v)
				y = m - 1; // 4
			else
				x = m + 1; // 5
		}
		return -1;// 6
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(search(arr1, 0, arr1.length - 1, 8));
	}
}
