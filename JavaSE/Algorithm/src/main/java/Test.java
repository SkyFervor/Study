import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		long n = 99999999;
		boolean[] choice = new boolean[]{true, false, false, false};
		int size = choice.length;

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < n; i++) {
			int first = choose(size);
			int compere;
			do {
				compere = choose(size);
			} while (compere == first || choice[compere]);

			if (choice[first]) {
				sum1 += 100;
			}

			int second;
			do {
				second = choose(size);
			} while (second == compere);
			if (choice[second]) {
				sum2 += 100;
			}
		}

		System.out.println(new BigDecimal(sum1).divide(new BigDecimal(n), 4, RoundingMode.CEILING));
		System.out.println(new BigDecimal(sum2).divide(new BigDecimal(n), 4, RoundingMode.CEILING));
	}

	private static final Random random = new Random();
	public static int choose(int size) {
		return random.nextInt(size);
	}
}
