package recursion;

/**
 * 打印1到最大的n位数
 */
public class Print1toMaxNumOfNDigits {

	/**
	 * 入口，参数判断、初始化
	 * 
	 * @param n
	 * @throws Exception
	 */
	public static void start(int n) throws Exception {
		if (n <= 0)
			throw new Exception("parameter exception");

		char[] num = new char[n];
		recursive(num, 0);
	}

	/**
	 * 递归填充各位，填充满时打印
	 * 
	 * @param num
	 * @param n
	 * @param index
	 */
	public static void recursive(char[] num, int index) {
		if (index == num.length) {
			printNum(num);
			return;
		}

		for (int i = 0; i < 10; i++) {
			num[index] = (char) ('0' + i);
			recursive(num, index + 1);
		}

	}

	/**
	 * 打印char[]，忽略掉前面的'0'
	 * 
	 * @param num
	 */
	public static void printNum(char[] num) {
		StringBuilder result = new StringBuilder();

		boolean start = false;
		for (char c : num) {
			if (!start && c != '0')
				start = true;

			if (start)
				result.append(c);
		}

		System.out.println(result.toString());
	}

	public static void main(String[] args) throws Exception {
		int n = 2;
		start(n);
	}
}
