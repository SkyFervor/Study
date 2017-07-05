package question;

/**
 * 求二进制数中1的个数
 */
public class NumOf1InBinaries {

	/**
	 * n为负数时会导致死循环
	 * 
	 * @param n
	 * @return
	 */
	public static int fun1(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n = n >> 1;
		}
		return count;
	}

	/**
	 * 常规解法
	 * 
	 * @param n
	 * @return
	 */
	public static int fun2(int n) {
		int count = 0;

		int flag = 1;
		while (flag != 0) {
			if ((n & flag) > 0)
				count++;
			flag = flag << 1;
		}

		return count;
	}

	/**
	 * 高效解法
	 * 
	 * @param n
	 * @return
	 */
	public static int fun3(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 68;
		System.out.println(fun1(n));
		System.out.println(fun2(n));
		System.out.println(fun3(n));
	}
}
