package question;

/**
 * 替换空格
 * 将一个字符串中的空格替换成“%20”
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
	public static String replace(StringBuilder str) {
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				n++;
		}
		int i = str.length() - 1;
		int j = i + n * 2;
		char[] result = new char[j + 1];
		while (j >= i && i >= 0) {
			char c = str.charAt(i);
			if (c != ' ')
				result[j--] = c;
			else {
				result[j--] = '0';
				result[j--] = '2';
				result[j--] = '%';
			}
			i--;
		}
		return new String(result);
	}

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("hello world");
		System.out.println(replace(str));
	}
}
