package recursion;

import java.util.TreeSet;

/**
 * 按字典序输出一个字符串中字符的所有排列
 */
public class Permutation {
	public static void permutation(char[] c, int i, TreeSet<String> result) {
		if (i == c.length) {
			result.add(new String(c));
			return;
		}

		for (int j = i; j < c.length; j++) {
			char tmp = c[j];
			c[j] = c[i];
			c[i] = tmp;

			permutation(c, i + 1, result);

			tmp = c[j];
			c[j] = c[i];
			c[i] = tmp;
		}
	}

	public static void main(String[] args) {
		String str = "aa";
		TreeSet<String> result = new TreeSet<>();
		permutation(str.toCharArray(), 0, result);

		for (String s : result)
			System.out.println(s);
	}
}
