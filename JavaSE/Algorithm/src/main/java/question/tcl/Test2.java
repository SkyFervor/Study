package question.tcl;

/**
 * 提取字符串中的数字
 */
public class Test2 {
	public static void main(String[] args) {
		String s = "abc0de1fg2hij3klmno456p7qr89";

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9')
				result.append(c);
		}

		System.out.println(result.toString());
	}
}
