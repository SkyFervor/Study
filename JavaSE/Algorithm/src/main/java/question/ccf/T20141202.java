package question.ccf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 问题描述
 * 
 * 　　在图像编码的算法中，需要将一个给定的方形矩阵进行Z字形扫描(Zigzag Scan)。给定一个n×n的矩阵，Z字形扫描的过程如下图所示：
 * 
 * 　　对于下面的4×4的矩阵，
 * 　　1 5 3 9
 * 　　3 7 5 6
 * 　　9 4 6 4
 * 　　7 3 1 3
 * 　　对其进行Z字形扫描后得到长度为16的序列：
 * 　　1 5 3 9 7 3 9 5 4 7 3 6 6 4 1 3
 * 　　请实现一个Z字形扫描的程序，给定一个n×n的矩阵，输出对这个矩阵进行Z字形扫描的结果。
 * 
 * 输入格式
 * 
 * 　　输入的第一行包含一个整数n，表示矩阵的大小。
 * 　　输入的第二行到第n+1行每行包含n个正整数，由空格分隔，表示给定的矩阵。
 * 
 * 输出格式
 * 
 * 　　输出一行，包含n×n个整数，由空格分隔，表示输入的矩阵经过Z字形扫描后的结果。
 * 
 * 样例输入
 * 
 * 4
 * 1 5 3 9
 * 3 7 5 6
 * 9 4 6 4
 * 7 3 1 3
 * 
 * 样例输出
 * 
 * 1 5 3 9 7 3 9 5 4 7 3 6 6 4 1 3
 * 
 * 评测用例规模与约定
 * 
 * 　　1≤n≤500，矩阵元素为不超过1000的正整数。
 */
public class T20141202 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = scanner.nextInt();
		scanner.close();

		int x = 0, y = 0;
		int count = 1;
		boolean direction = true;
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < n * 2 - 1; i++) {
			for (int j = 0; j < count; j++) {
				results.add(matrix[x][y]);

				if (j == count - 1)
					break;

				if (direction) {
					x--;
					y++;
				} else {
					x++;
					y--;
				}
			}

			if (i <= n - 2) {
				count++;

				if (x == 0)
					y++;
				else if (y == 0)
					x++;
			} else {
				count--;

				if (y == n - 1)
					x++;
				else if (x == n - 1)
					y++;
			}

			direction = !direction;
		}

		for (Integer result : results) {
			System.out.print(result + " ");
		}
	}
}
