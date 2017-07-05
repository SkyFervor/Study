package question;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class MinNumberInRotateArray {
	/**
	 * O(n)
	 * 
	 * @param array
	 * @return
	 */
	public static int min1(int[] array) {
		if (array.length == 0)
			return 0;

		int i;
		for (i = 0; i < array.length - 1; i++)
			if (array[i] > array[i + 1])
				break;

		if (i == array.length - 1)
			return array[0];
		return array[i + 1];
	}

	/**
	 * O(logn)
	 * 
	 * @param array
	 * @return
	 */
	public static int min2(int[] array) {
		if (array.length == 0)
			return 0;

		int i = 0, j = array.length - 1;
		int mid = i;
		while (array[i] >= array[j]) {
			if (j - i == 1) {
				mid = j;
				break;
			}

			mid = (i + j) / 2;
			if (array[i] == array[mid] && array[mid] == array[j]) {
				return min1(array);
			}

			if (array[mid] >= array[i])
				i = mid;
			else if (array[mid] <= array[j])
				j = mid;
		}

		return array[mid];
	}

	public static void main(String[] args) {
		int[] array = { 1 };
		System.out.println(min1(array));
		System.out.println(min2(array));
	}
}
