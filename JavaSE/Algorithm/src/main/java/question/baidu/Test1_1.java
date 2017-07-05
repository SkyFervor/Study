package question.baidu;

import java.util.Scanner;

/**
 * 求数列总和
 * 输入数列首项n，数列项数m
 * 数列后一项为前一项的平方根
 */
public class Test1_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double n = scanner.nextInt();
			int m = scanner.nextInt();

			double num = n;
			for (int i = 1; i < m; i++) {
				n = Math.sqrt(n);
				num += n;
			}

			System.out.printf("%.2f", num);
		}
		scanner.close();
	}
}
