package dynamicProgramming;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(a));

		int[] b = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(maxSubArray(b));
	}

	public static int maxSubArray(int[] a) {
		int newSum = a[0];
		int maxSum = a[0];
		for (int i = 1; i < a.length; i++) {
			newSum = Math.max(newSum + a[i], a[i]);
			maxSum = Math.max(maxSum, newSum);
		}
		return maxSum;
	}

	static class NaiveApproach {
		public static int WrongMaxSubArray(int[] a) {
			int sum = 0;
			int maxSum = Integer.MIN_VALUE;

			for (int i = 0; i < a.length; i++) {
				sum += a[i];
				maxSum = Math.max(maxSum, sum);

				if (sum < 0) // 当数组元素全为负时无法计算
					sum = 0;
			}

			return maxSum;
		}
	}
}
