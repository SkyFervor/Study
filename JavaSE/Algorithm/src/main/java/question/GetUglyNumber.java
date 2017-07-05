package question;

/**
 * 从小到大的第n个丑数
 * 丑数：只包含因子2、3、5，如4、6。14不是丑数因为它有因子7
 */
public class GetUglyNumber {

	public static int minNum(int a, int b, int c) {
		a = a < b ? a : b;
		return a < c ? a : c;
	}

	public static int getUglyNumber(int index) {
		if (index <= 0)
			return 0;

		int[] nums = new int[index];
		nums[0] = 1;
		int m2 = 0, m3 = 0, m5 = 0;
		int next = 1;

		while (next < index) {
			int min = minNum(nums[m2] * 2, nums[m3] * 3, nums[m5] * 5);
			nums[next] = min;

			while (nums[m2] * 2 <= min)
				m2++;
			while (nums[m3] * 3 <= min)
				m3++;
			while (nums[m5] * 5 <= min)
				m5++;

			next++;
		}

		return nums[index - 1];
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = -1; i <= n; i++)
			System.out.println(getUglyNumber(i));
	}
}
