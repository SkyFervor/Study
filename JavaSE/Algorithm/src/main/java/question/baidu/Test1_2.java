package question.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找范围内的水仙花数（每个位上的数字的三次方的和等于该数）
 */
public class Test1_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();

			List<Integer> results = new ArrayList<Integer>();
			while (m <= n) {
				int temp = m;
				int sum = 0;
				while (temp > 0) {
					sum += Math.pow(temp % 10, 3);
					temp /= 10;
				}
				if (sum == m)
					results.add(m);
				m++;
			}

			if (results.isEmpty()) {
				System.out.println("no");
				continue;
			}
			for (Integer result : results) {
				System.out.print(result + " ");
			}
			System.out.println();

		}
		scanner.close();
	}
}
