package question.ccf;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			num.add(sc.nextInt());
		}

		sc.close();

		int count = 0;
		for (int i = 0; i < num.size() - 1; i++) {
			for (int j = i + 1; j < num.size(); j++) {
				if (num.get(i).equals(-num.get(j))) {
					num.remove(j);
					count++;
					continue;
				}
			}
		}

		System.out.println(count);
	}
}
