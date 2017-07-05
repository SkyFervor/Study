package question.acmcoder;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		long t1 = scanner.nextLong();
		long t2 = scanner.nextLong();
		long t3 = scanner.nextLong();
		long t4 = scanner.nextLong();
		scanner.close();

		long time1 = (n - 1) * t4;
		long time2 = t2 * 2 + t3;
		if (m >= n)
			time2 += (m - 1) * t1;
		else {
			long tmp1 = time2 + (n - m) * t1 + (n - 1) * t1;
			long tmp2 = time2 + (n - m) * t4 + (m - 1) * t1;
			time2 = Math.min(tmp1, tmp2);
		}
		System.out.println(Math.min(time1, time2));
	}
}
