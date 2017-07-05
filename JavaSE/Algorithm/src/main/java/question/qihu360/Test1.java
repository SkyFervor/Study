package question.qihu360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟编辑器
 * 输入待编辑字符串，'#'表示退格，'@'表示全部删除
 * 输出编辑好的字符串
 */
public class Test1 {
	public static void main(String[] args) {
		// 输入
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		List<String> results = new ArrayList<String>();
		int i = 0;
		while (i < n && scanner.hasNext()) {
			String line = scanner.nextLine();
			results.add(editor(line));
			i++;
		}
		scanner.close();

		// 输出
		for (String result : results)
			System.out.println(result);

	}

	public static String editor(String line) {
		char[] result = new char[line.length()];
		int j = 0;
		// 遍历字符串
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '#')
				j = j > 0 ? j - 1 : 0; // 退格时防止j溢出
			else if (c == '@')
				j = 0;
			else {
				result[j] = c;
				j++;
			}
		}
		return new String(result).substring(0, j);// 截取有效部分并返回
	}
}
