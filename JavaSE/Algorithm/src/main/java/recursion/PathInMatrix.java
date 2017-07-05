package recursion;

/**
 * 矩阵中的路径
 * 判断一个矩阵中是否存在一条包含所给字符串所有字符的路径
 */
public class PathInMatrix {
	char[] matrix;
	int rows, cols;

	public PathInMatrix(char[] matrix, int rows, int cols) {
		this.matrix = matrix;
		this.rows = rows;
		this.cols = cols;
	}

	public boolean hasPath(char[] str) {
		if (matrix == null || rows <= 0 || cols <= 0)
			return false;
		if (str == null || str.length == 0)
			return false;

		boolean[] flag = new boolean[rows * cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (findPath(flag, i, j, str, 0))
					return true;
			}
		}
		return false;
	}

	public boolean findPath(boolean[] flag, int x, int y, char[] str, int index) {
		if (index == str.length)
			return true;

		if (x < 0 || x >= rows)
			return false;
		if (y < 0 || y >= cols)
			return false;

		if (flag[x * cols + y] || matrix[x * cols + y] != str[index])
			return false;

		flag[x * cols + y] = true;
		boolean result = findPath(flag, x + 1, y, str, index + 1)
				|| findPath(flag, x - 1, y, str, index + 1)
				|| findPath(flag, x, y + 1, str, index + 1)
				|| findPath(flag, x, y - 1, str, index + 1);
		flag[x * cols + y] = false;
		return result;
	}

	public static void main(String[] args) {
		char[] matrix = "ABCESFCSADEE".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "ABCCED".toCharArray();

		PathInMatrix pm = new PathInMatrix(matrix, rows, cols);
		System.out.println(pm.hasPath(str));
	}
}
