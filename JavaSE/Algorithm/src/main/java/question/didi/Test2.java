package question.didi;

import java.util.Scanner;

/**
 * 求矩阵中所有2*2子矩阵的和的最大值
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] mtx = scanner.nextLine().split(";");
		scanner.close();

		int[][] a = new int[mtx.length][];
		for (int i = 0; i < mtx.length; i++) {
			String[] nums = mtx[i].trim().split(" ");
			int[] column = new int[nums.length];
			for (int j = 0; j < nums.length; j++)
				column[j] = Integer.parseInt(nums[j]);
			a[i] = column;
		}

		int max = 0;
		for (int i = 0; i < a.length - 1; i++)
			for (int j = 0; j < a[i].length - 1; j++)
				max = Math.max(max, a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 1][j + 1]);
		System.out.println(max);
	}
}
