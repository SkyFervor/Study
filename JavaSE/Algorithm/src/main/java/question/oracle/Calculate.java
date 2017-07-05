package question.oracle;

import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLong()) {
			long num = scanner.nextLong();
			if (num == 0)
				break;

			long sum = 0;

			// +2的倍数
			long last = num % 2 == 0 ? num : num - 1;
			sum += (2 + last) * (last / 2) / 2; // (a1+an)*n/2

			// +5的奇数次倍
			long times_5 = Math.round((double) num / 10);
			sum += times_5 * 5 + times_5 * (times_5 - 1) / 2 * 10; // n*a1+n*(n-1)/2*d

			// +3的奇数次倍
			long times_3 = Math.round((double) num / 6);
			sum += times_3 * 3 + times_3 * (times_3 - 1) / 2 * 6; // n*a1+n*(n-1)/2*d

			// -15的奇数次倍
			long times_15 = Math.round((double) num / 30);
			sum -= times_15 * 15 + times_15 * (times_15 - 1) / 2 * 30; // n*a1+n*(n-1)/2*d

			System.out.format("%d\r\n", sum);
		}
		scanner.close();
	}
}