package question.acmcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;

			List<Integer> x = new LinkedList<>();
			List<Integer> t = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				x.add(scanner.nextInt());
				t.add(scanner.nextInt());
			}

			System.out.println(getCoin(x, t, 5, 0));
		}
		scanner.close();

	}

	public static int getCoin(List<Integer> x, List<Integer> t, int local, int time) {
		if (local < 0 || local > 10)
			return 0;

		boolean overtime = true;
		int num = 0;
		for (int i = 0; i < x.size(); i++) {
			if (time == t.get(i) && local == x.get(i))
				num++;
			if (overtime && time <= t.get(i))
				overtime = false;
		}
		if (overtime)
			return 0;

		time++;
		int num1 = getCoin(x, t, local, time);
		int num2 = getCoin(x, t, local + 1, time);
		int num3 = getCoin(x, t, local - 1, time);

		return num + Math.max(num1, Math.max(num2, num3));
	}
}
