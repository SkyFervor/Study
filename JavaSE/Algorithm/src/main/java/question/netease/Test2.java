package question.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入路灯个数n，路的长度l
 * 输入n个路灯的位置
 * 找路灯要覆盖整条道路的最小照明长度
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int l = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scanner.nextInt();
		scanner.close();

		Arrays.sort(a); // 排序路灯的位置

		// 找两两相隔的路灯的最大间距
		int max = 0;
		for (int i = 1; i < n; i++)
			max = Math.max(max, a[i] - a[i - 1]);

		max = Math.max(max, l - a[n - 1]);

		// 修正在开头（0）与末尾（l）没有路灯时的情况
		if (a[n - 1] != l && (l - a[n - 1]) * 2 > max)
			max = (l - a[n - 1]) * 2;
		if (a[0] != 0 && a[0] * 2 > max)
			max = a[0] * 2;

		System.out.println(String.format("%.2f", (double) max / 2));
	}
}
