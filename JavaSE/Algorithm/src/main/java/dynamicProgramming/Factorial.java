package dynamicProgramming;
public class Factorial {
	public static void main(String[] args) {
		int n = 6;

		System.out.println(factorial(n));
	}

	public static int factorial(int n) {
		if (n < 0)
			return -1;

		int result = 1;
		for (int i = 2; i <= n; i++)
			result *= i;
		return result;
	}
}
