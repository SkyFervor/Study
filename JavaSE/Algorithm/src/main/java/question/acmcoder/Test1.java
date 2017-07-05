package question.acmcoder;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scanner.nextInt();

		int m = scanner.nextInt();
		int[] b = new int[m];
		int[] c = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
			c[i] = scanner.nextInt();
		}
		scanner.close();

		int min = Integer.MAX_VALUE;
		boolean find = false;
		for (int i = 0; i < n; i++) {
			int time = composition(a[i], b, c);
			if (time == -1)
				continue;
			find = true;
			min = Math.min(min, time);
		}
		if (!find)
			System.out.println("It is not true!");
		else
			System.out.println(min);
	}

	public static int composition(int a, int[] b, int[] c) {
		int min = Integer.MAX_VALUE;
		boolean find = false;
		for (int i = 0; i < b.length; i++) {
			if (a == b[i]) {
				find = true;
				min = Math.min(min, c[i]);
			} else if (a > b[i]) {
				int time = composition(a - b[i], b, c);
				if (time == -1)
					continue;
				find = true;
				min = Math.min(min, c[i] + time);
			}
		}

		if (!find)
			return -1;
		return min;
	}
}
