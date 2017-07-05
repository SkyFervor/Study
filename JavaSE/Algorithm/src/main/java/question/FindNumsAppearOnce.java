package question;

/**
 * 找数组中两个只出现了一次的数
 * 其余数都出现了两次
 */
public class FindNumsAppearOnce {
	// 一个数与自身异或，结果必为0
	public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2)
			return;

		int result = 0;
		for (int num : array)
			result ^= num;

		if (result == 0)
			return;

		int index = findFirstBitIs1(result);

		for (int n : array) {
			if (bitIs1(n, index))
				num1[0] ^= n;
			else
				num2[0] ^= n;
		}
	}

	public static int findFirstBitIs1(int num) {
		int index = 0;
		while (num != 0 && (num & 1) == 0) {
			num = num >>> 1;
			index++;
		}
		return index;
	}

	public static boolean bitIs1(int num, int index) {
		num = num >>> index;
		return (num & 1) == 1;
	}
}
