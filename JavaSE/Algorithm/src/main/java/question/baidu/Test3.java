package question.baidu;

import java.util.Scanner;

/**
 * 公交上下车过程中的最多人数
 * 公交车初始人数为0
 * 第一行输入停靠次数n
 * 输入每次停靠的下车人数、上车人数
 * 
 */
public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum - scanner.nextInt() + scanner.nextInt();
			max = Math.max(max, sum);
		}
		scanner.close();

		System.out.println(max);
	}
}
