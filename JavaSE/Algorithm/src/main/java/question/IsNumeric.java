package question;

/**
 * 判断字符串是否表示数值
 * 
 * 例："+100","5e2","-123","3.1416","-1E-16"都表示数值。
 * "12e","1a3.14","1.2.3","+-5","12e+4.3"都不是
 */
public class IsNumeric {
	public static boolean isNumeric(char[] str) {
		if (str == null || str.length == 0)
			return false;

		int i = 0;
		char c = str[i];
		if (c == '-' || c == '+') {
			i++;
		}

		boolean point = false;
		for (; i < str.length; i++) {
			c = str[i];
			if (c == 'E' || c == 'e') {
				i++;
				if (i == str.length)
					return false;
				break;
			} else if (c == '.' && !point) {
				if (i == str.length - 1)
					return true;

				point = true;
				i++;
				if (i == str.length || str[i] < '0' || str[i] > '9')
					return false;
			} else if (c < '0' || c > '9')
				return false;
		}

		if (i == str.length)
			return true;

		c = str[i];
		if (c == '-' || c == '+') {
			i++;
			if (i == str.length || str[i] < '0' || str[i] > '9')
				return false;
		}

		for (; i < str.length; i++) {
			c = str[i];
			if (c < '0' || c > '9')
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumeric("600.".toCharArray())); // true
		System.out.println(isNumeric("123.45e+6".toCharArray())); // true
		System.out.println(isNumeric("-.123".toCharArray())); // true
		System.out.println(isNumeric("12e".toCharArray())); // false
	}
}
