package question.tcl;

import java.util.Scanner;

/**
 * 求可以整除x的非奇数
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		scanner.close();

		int[] arr = new int[x];
		int n = proc(x, arr);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int proc(int x, int pp[]) {
		int n = 0;
		for (int i = 2; i <= x; i += 2)
			if (x % i == 0)
				pp[n++] = i;
		return n;
	}
}
