package question;

/**
 * 顺时针打印矩阵数值
 */
public class ClockwisePrintMatrix {
	public static void print(int[][] a) {
		if (a.length == 0)
			return;
		if (a[0].length == 0)
			return;

		int row_l = 0, row_h = a.length - 1;
		int col_l = 0, col_h = a[0].length - 1;

		while (row_l <= row_h && col_l <= col_h) {
			for (int i = col_l; i <= col_h; i++)
				System.out.print(a[row_l][i] + " ");
			System.out.println();
			row_l++;

			for (int i = row_l; i <= row_h; i++)
				System.out.print(a[i][col_h] + " ");
			System.out.println();
			col_h--;

			if (row_l > row_h)
				break;
			for (int i = col_h; i >= col_l; i--)
				System.out.print(a[row_h][i] + " ");
			System.out.println();
			row_h--;

			if (col_l > col_h)
				break;
			for (int i = row_h; i >= row_l; i--)
				System.out.print(a[i][col_l] + " ");
			System.out.println();
			col_l++;
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		print(a);

		int[][] b = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		print(b);
	}
}
