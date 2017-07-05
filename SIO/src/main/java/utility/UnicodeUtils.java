package utility;

public class UnicodeUtils {
	public static String unicode2String(String unicode) {

		StringBuilder string = new StringBuilder();

		String[] hex = unicode.split("\\\\u");

		for (int i = 1; i < hex.length; i++) {
			String s = hex[i];
			if (s.length() > 4){
				string.append(s.substring(4));
				s = s.substring(0, 4);
			}
				
			// 转换出每一个代码点
			int data = Integer.parseInt(s, 16);

			// 追加成string
			string.append((char) data);
		}

		return string.toString();
	}
}
