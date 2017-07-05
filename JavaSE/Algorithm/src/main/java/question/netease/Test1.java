package question.netease;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < m; i++)
			a[i] = scanner.nextInt();

		int n = scanner.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++)
			b[i] = scanner.nextInt();
		scanner.close();

	}
}
