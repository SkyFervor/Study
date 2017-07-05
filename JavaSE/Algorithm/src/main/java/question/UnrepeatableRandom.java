package question;

import java.util.Arrays;
import java.util.Random;

/**
 * 利用随机数产生1-1000中900个不重复的数
 * 算法复杂度O(n)
 * 空间复杂度O(n)
 */
public class UnrepeatableRandom {

	public static int[] getRandom(int number, int lower, int higher) {
		int[] result = new int[number];

		int length = higher - lower;
		int[] tmp = new int[length];
		for (int i = 0; i < length; i++)
			tmp[i] = lower + i;

		Random random = new Random();
		int end = length - 1;
		for (int i = 0; i < number; i++) {
			int index = random.nextInt(end + 1);
			result[i] = tmp[index];
			tmp[index] = tmp[end--];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = getRandom(9, 1, 10 + 1);
		System.out.print(Arrays.toString(result));
	}
}
