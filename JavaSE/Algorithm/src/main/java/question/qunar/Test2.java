package question.qunar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求三个数组的交集
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a_l = scanner.nextInt();
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		for (int i = 0; i < a_l; i++)
			a.put(scanner.nextInt(), 1);

		int b_l = scanner.nextInt();
		int[] b = new int[b_l];
		for (int i = 0; i < b_l; i++)
			b[i] = scanner.nextInt();

		int c_l = scanner.nextInt();
		int[] c = new int[c_l];
		for (int i = 0; i < c_l; i++)
			c[i] = scanner.nextInt();
		scanner.close();

		/*		a.retainAll(b);
				a.retainAll(c);*/

		for (int num_b : b)
			if (a.containsKey(num_b))
				a.replace(num_b, 2);

		for (int num_c : c) {
			Integer num = a.get(num_c);
			if (num != null && num == 2)
				a.replace(num_c, 3);
		}

		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : a.entrySet())
			if (entry.getValue() == 3)
				result.append(entry.getKey() + " ");
		System.out.println(result.toString().trim());
	}
}
