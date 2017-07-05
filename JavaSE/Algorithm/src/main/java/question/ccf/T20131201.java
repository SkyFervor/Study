package question.ccf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class T20131201 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
		int i;
		for (i = 0; i < n; i++) {
			int num = scanner.nextInt();
			if (nums.get(num) == null) {
				nums.put(num, 1);
			} else {
				nums.put(num, nums.get(num) + 1);
			}
		}
		scanner.close();

		Iterator<Integer> it = nums.keySet().iterator();
		int maxCount_num = it.next();
		while (it.hasNext()) {
			int num = it.next();

			if (nums.get(num) > nums.get(maxCount_num)) {
				maxCount_num = num;
			} else if (nums.get(num) == nums.get(maxCount_num) && num < maxCount_num) {
				maxCount_num = num;
			}
		}

		System.out.println(maxCount_num);
	}
}
