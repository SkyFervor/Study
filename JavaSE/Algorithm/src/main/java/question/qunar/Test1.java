package question.qunar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找稳定的最高版本号（第二版本是偶数时是稳定版）
 */
public class Test1 {

	public static void main(String[] args) {
		// 输入
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		List<String[]> versions = new ArrayList<String[]>();
		for (int i = 0; i < n; i++) {
			String[] ver = scanner.nextLine().split("\\.");

			// 筛选稳定版本
			if (Integer.parseInt(ver[1]) % 2 != 0)
				continue;

			versions.add(ver);
		}
		scanner.close();

		// 没有候选版本
		if (versions.isEmpty()) {
			System.out.println("no stable available");
			return;
		}

		// 遍历确定最高版本
		String[] lastest = versions.get(0);
		boolean equal;
		for (int i = 1; i < versions.size(); i++) {
			equal = false;
			String[] ver = versions.get(i);

			// 依次比较每个版本段
			int length = Math.min(ver.length, lastest.length);
			for (int j = 0; j < length; j++) {
				int c = compareString(ver[j], lastest[j]);
				if (c > 0) {
					lastest = ver;
					break;
				} else if (c < 0)
					break;

				if (j == length - 1)
					equal = true;
			}

			if (equal && ver.length > lastest.length)
				lastest = ver;
		}

		StringBuilder result = new StringBuilder();
		for (String num : lastest)
			result.append(num + ".");
		System.out.println(result.substring(0, result.length() - 1));
	}

	public static int compareString(String a, String b) {
		if (a.length() < b.length())
			return -1;
		else if (a.length() > b.length())
			return 1;

		return a.compareTo(b);
	}
}
