package question.meituan;

/**
 * 给定一个0,1矩阵和多个点
 * 将各点上下左右的四个点的数字反置
 */
public class InverseMatrix {
	public static int[] flip(int[][] colors, int[][] pivots) {
		for (int[] p : pivots) {
			int x = p[0] - 1;
			int y = p[1] - 1;

			if (y - 1 >= 0)
				colors[x][y - 1] = colors[x][y - 1] > 0 ? 0 : 1;

			if (y + 1 < colors[0].length)
				colors[x][y + 1] = colors[x][y + 1] > 0 ? 0 : 1;

			if (x - 1 >= 0)
				colors[x - 1][y] = colors[x - 1][y] > 0 ? 0 : 1;

			if (x + 1 < colors[0].length)
				colors[x + 1][y] = colors[x + 1][y] > 0 ? 0 : 1;
		}

		int[] result = new int[colors.length * colors[0].length];
		for (int i = 0; i < colors.length; i++)
			for (int j = 0; j < colors[i].length; j++)
				result[i * 4 + j] = colors[i][j];

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 },
				{ 0, 0, 1, 0 } };
		int[][] b = new int[][] { { 2, 2 }, { 3, 3 }, { 4, 4 } };

		flip(a, b);
	}
}
