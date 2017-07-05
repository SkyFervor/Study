package sort;

import java.util.Arrays;

public class HeapSort {

	/**
	 * 调整堆，保证其大根堆的结构
	 * 
	 * @param array
	 *        待调整堆
	 * @param low
	 * @param high
	 *        调整范围，值为树中的节点标号
	 *        <p>
	 *        对堆的调整实际上是对数组结构的操作，所以要进行 节点标号<==>数组下标 的转换
	 * @return 大根堆
	 */
	public static int[] sift(int[] array, int low, int high) {
		int i = low;// 父节点标号i
		int j = 2 * i;// 左子节点标号2i

		int temp = array[i - 1];// 父节点
		while (j <= high) {
			if (j < high && array[j - 1] < array[j]) // 存在右子节点且比左子节点大
				j++; // 调整j为右子节点

			if (temp < array[j - 1]) { // 子节点比父节点大
				array[i - 1] = array[j - 1]; // 将子节点调整到父节点位置

				// 调整i、j，向下继续查找符合temp的位置
				i = j;
				j = 2 * i;
			} else
				break;
		}
		array[i - 1] = temp; // 将temp调整到最终位置

		return array;
	}

	/**
	 * 堆排序过程
	 * 
	 * @param array
	 *        待排序数组
	 * @return 升序数组
	 */
	public static int[] sort(int[] array) {
		int length = array.length;

		// 从堆中第一个拥有子节点的位置（n/2）开始向前
		// 调整所有的子树
		for (int i = length / 2; i >= 1; i--) {
			sift(array, i, length);
		}

		// 进行 数组长度-1 次 交换过程
		for (int i = length; i >= 2; i--) {
			// 大根堆的根节点即为当前过程中的数组最大值
			// 将其与堆中最后一个元素交换
			int temp = array[0];
			array[0] = array[i - 1];
			array[i - 1] = temp;

			// 堆大小减1
			// 重新调整堆为大根堆
			sift(array, 1, i - 1);
		}

		return array;
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 6, 8, 7, 9, 0, 1, 3, 2, 4, 5 };

		System.out.println(Arrays.toString(sort(array)));
	}

}
