package question.baidu;

import java.util.Scanner;

/**
 * 求转移罪犯的方案数量
 * 要转移的人数固定，方案中每个人的编号必须连续，且每个人的罪行值不能超过指定值
 * 第一行输入罪犯总数n，罪行值限制t，要转移的人数c
 * 输入n个罪犯的罪行值
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int c = scanner.nextInt();

		int sum = 0; // 满足要求的选择方式数目
		int num = 0; // 模拟连续子数组，记录子数组的元素个数
		for (int i = 0; i < n; i++) {
			if (scanner.nextInt() <= t)
				num++; // 罪行值满足要求，元素个数+1
			else {
				if (num >= c)
					sum += num - c + 1; // 达到要转移的罪犯数目，计入sum

				num = 0;
			}
		}
		// 对最后一个子数组进行判断
		if (num >= c)
			sum += num - c + 1;

		scanner.close();

		System.out.println(sum);
	}
}
