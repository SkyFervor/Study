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

	public static int binarySearch(int[] arr, int val) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int low = 0;
		int high = arr.length;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] < val) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] arr, int low, int high, int val) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == val) {
			return mid;
		} else if (arr[mid] < val) {
			return recursiveBinarySearch(arr, mid + 1, high, val);
		} else {
			return recursiveBinarySearch(arr, low, mid - 1, val);
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(search(arr1, 0, arr1.length - 1, 8));
		System.out.println(binarySearch(arr1, 6));
		System.out.println(recursiveBinarySearch(arr1, 0, arr1.length - 1, 5));
	}
}
