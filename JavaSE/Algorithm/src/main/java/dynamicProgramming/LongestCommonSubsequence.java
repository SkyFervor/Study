package dynamicProgramming;
import java.util.Arrays;

public class LongestCommonSubsequence {

	public static int getLcsLength(String query, String text) {
		int max = 0;
		int[][] tmp = new int[20][20];

		for (int i = 0; i < query.length(); i++) {
			for (int j = 0; j < text.length(); j++) {
				if (query.charAt(i) == text.charAt(j)) {
					if (i == 0 || j == 0)
						tmp[i][j] = 0;
					else
						tmp[i][j] = tmp[i - 1][j - 1] + 1;

					if (max < tmp[i][j])
						max = tmp[i][j];
				}
			}
		}

		for (int[] row : tmp) {
			System.out.println(Arrays.toString(row));
		}

		return max;
	}

	public static void main(String[] args) {
		String query = "acbac";
		String text = "acaccbabb";

		System.out.println(getLcsLength(query, text));
	}
}
