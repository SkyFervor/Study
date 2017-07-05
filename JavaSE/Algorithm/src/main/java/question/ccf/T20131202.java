package question.ccf;

import java.util.Scanner;

public class T20131202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		char[] ISBN = scanner.nextLine().toCharArray();
		final int lastIndex = 13 - 1;
		scanner.close();

		int sum = 0;
		int factor = 1;
		for (int i = 0; i < lastIndex - 1; i++) {
			if (ISBN[i] == '-')
				continue;

			sum += (int) (ISBN[i] - '0') * factor;
			factor++;
		}

		int cal = sum % 11;
		char id = ISBN[lastIndex];
		if (cal == 10) {
			if (id == 'X') {
				System.out.println("Right");
			} else {
				ISBN[lastIndex] = 'X';
				System.out.println(String.valueOf(ISBN));
			}
		} else {
			if (id != 'X' && cal == (int) (id - '0')) {
				System.out.println("Right");
			} else {
				ISBN[lastIndex] = (char) (cal + '0');
				System.out.println(String.valueOf(ISBN));
			}
		}
	}
}