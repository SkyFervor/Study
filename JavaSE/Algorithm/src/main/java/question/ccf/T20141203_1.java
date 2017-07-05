package question.ccf;

import java.util.Scanner;

public class T20141203_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int num = 0;
		float[][] trades = new float[5000][];
		// while (scanner.hasNext()) {
		while (num < 7) {
			switch (scanner.next()) {
			case "buy":
				trades[num] = new float[3];
				trades[num][0] = 1;
				trades[num][1] = scanner.nextFloat();
				trades[num][2] = scanner.nextInt();
				break;
			case "sell":
				trades[num] = new float[3];
				trades[num][0] = -1;
				trades[num][1] = scanner.nextFloat();
				trades[num][2] = scanner.nextInt();
				break;
			case "cancel":
				trades[num] = null;
				trades[scanner.nextInt() - 1] = null;
				break;
			default:
				break;
			}
			num++;
		}
		scanner.close();

		for (int i = 0; i < num; i++) {
			float[] trade = trades[i];
			if (trade == null)
				System.out.println("null");
			else {
				if (trade[0] == 1)
					System.out.print("buy");
				else
					System.out.print("sell");

				System.out.print(" " + trade[1]);
				System.out.println(" " + trade[2]);
			}
		}
	}

}
