package leetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 网格路径总数
 */
public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new int[1]));
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		long[][] path = new long[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (0 == i || 0 == j) {
					path[i][j] = 1;
					continue;
				}
				path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
		System.out.println(path[m - 1][n - 1]);
	}

}
