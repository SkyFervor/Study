package question.baidu;

import java.util.Scanner;

/**
 * 求路径总数
 * 第一行输入矩阵的高m和宽n
 * 输入n*m的矩阵
 * 1为可达，0为不可达
 */
public class Test1 {

	public static int getPathNum(int row, int col) {
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] area = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				area[i][j] = scanner.nextInt();
		scanner.close();

	}
}
