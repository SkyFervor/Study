package question.didi;

import java.util.Scanner;

/**
 * 求和为0的最大子集
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nums = scanner.nextLine().split(" ");
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			a[i] = Integer.parseInt(nums[i]);
		scanner.close();

		int start = 0, length = 0;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];

				if (sum == 0 && j - i + 1 > length) {
					start = i;
					length = j - i + 1;
				}
			}
		}

		for (int i = start; i < length; i++)
			System.out.print(a[i] + " ");
	}
}
