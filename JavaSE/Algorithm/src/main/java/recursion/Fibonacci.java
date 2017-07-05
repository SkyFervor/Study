package recursion;

/**
 * 斐波那契数列
 */
public class Fibonacci {
	// 递归算法
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}

	// 动态规划
	public static int[] fib2(int n) {
		int[] a;
		a = new int[n + 1];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i <= n; i++)
			a[i] = a[i - 1] + a[i - 2];
		return a;
	}

	// 动态规划不保存中间结果算法
	public static int fib3(int n) {
		int a = 0, b = 1;
		int tmp;
		while (n-- != 0) {
			tmp = a + b;
			a = b;
			b = tmp;
		}
		return a;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 20; i++)
			System.out.print(fib(i) + " ");

		System.out.println();

		int[] result = fib2(20);
		for (int i = 0; i <= 20; i++)
			System.out.print(result[i] + " ");

		System.out.println();

		for (int i = 0; i <= 20; i++)
			System.out.print(fib3(i) + " ");
	}
}
