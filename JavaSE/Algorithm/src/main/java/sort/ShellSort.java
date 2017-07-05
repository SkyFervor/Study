package sort;
import java.util.Arrays;

public class ShellSort {

	/**
	 * 原理
	 * 
	 * @param t
	 */
	public static <T extends Comparable<? super T>> void sort(T[] t) {
		T tmp;
		int i, j;

		// 增量gap（gap(1)=n/2,gap(i+1)=gap(i)/2）
		for (int gap = t.length / 2; gap > 0; gap /= 2) {
			// 分为了gap组
			for (int count = 0; count < gap; count++) {
				// 每组组内
				// 直接插入排序
				for (i = count + gap; i < t.length; i += gap) {
					tmp = t[i];
					j = i - gap;
					while (j >= 0 && tmp.compareTo(t[j]) < 0) {
						t[j + gap] = t[j];
						j -= gap;
					}
					t[j + gap] = tmp;
				}
			}
		}
	}

	/**
	 * 优化后的算法
	 * 
	 * @param t
	 */
	public static <T extends Comparable<? super T>> void sort1(T[] t) {
		T tmp;
		int j;

		for (int gap = t.length / 2; gap > 0; gap /= 2) {
			// 不再为每组排序分别遍历，在一次遍历中对所有组都进行直接插入排序
			for (int i = gap; i < t.length; i++) {
				tmp = t[i];
				for (j = i; j >= gap && tmp.compareTo(t[j - gap]) < 0; j -= gap)
					t[j] = t[j - gap];
				t[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
