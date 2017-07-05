package question;

public class MaximumSubarrayOfContinuousValues {
	public static int maximumSubarrayOfContinuousValues(int[] arr) {
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (diff != 1 && diff != -1) {
				max = Math.max(max, arr[i]);
				continue;
			}

			int sum = arr[i - 1];
			while (i < arr.length && arr[i] >= 0) {
				if (arr[i] - arr[i - 1] != diff)
					break;
				sum += arr[i];
				i++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 6, 7, 9 };
		System.out.println(maximumSubarrayOfContinuousValues(arr1));

		int[] arr2 = { -1, -2, 6, 7, 9 };
		System.out.println(maximumSubarrayOfContinuousValues(arr2));

		int[] arr3 = { 1, 2, -6, 7, 9 };
		System.out.println(maximumSubarrayOfContinuousValues(arr3));

		int[] arr4 = { -1, -2, -6, -7, -9 };
		System.out.println(maximumSubarrayOfContinuousValues(arr4));

		int[] arr5 = { 1, 3, 5, 7, 9 };
		System.out.println(maximumSubarrayOfContinuousValues(arr5));
	}
}
