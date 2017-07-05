package priority;

import java.util.Arrays;

/**
 * Created by shuhaoz
 * 2017/07/03 18:45
 */
public class PriorityTest {
	public static void main(String[] args) {
		int[] arr = new int[3];
		int i = 1;
		arr[i << 1] = 1;
		System.out.println(Arrays.toString(arr));
		System.out.println(i);
	}
}
