package question.ccf;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class T20141203 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = 0;
		Map<Integer, Trade> trades = new TreeMap<Integer, Trade>();
		Set<Float> prices = new HashSet<Float>();
		while (scanner.hasNext()) {
			// while (num < 7) {

			String type = scanner.next();
			if (type.equals("cancel"))
				trades.remove(scanner.nextInt());
			else {
				Float price = scanner.nextFloat();
				prices.add(price);

				Trade trade = new Trade(type.equals("buy"), price, scanner.nextInt());
				trades.put(num + 1, trade);
			}

			num++;
		}
		scanner.close();

		Trade result = new Trade(false, 0.0f, 0);
		for (Float price : prices) {
			long volume = tradingVolume(price, trades);

			if (result.volume < volume) {
				result.price = price;
				result.volume = volume;
			} else if (result.volume == volume && result.price < price)
				result.price = price;
		}

		System.out.println(String.format("%.2f", result.price) + " " + result.volume);
	}

	protected static long tradingVolume(float price, Map<Integer, Trade> trades) {
		long buy_volume = 0;
		long sell_volume = 0;
		for (Trade trade : trades.values()) {
			if (trade.isBuy && trade.price >= price)
				buy_volume += trade.volume;
			else if (!trade.isBuy && trade.price <= price)
				sell_volume += trade.volume;
		}

		if (buy_volume < sell_volume)
			return buy_volume;
		else
			return sell_volume;
	}
}

class Trade {
	public boolean isBuy;
	public float price;
	public long volume;

	public Trade(boolean isBuy, float price, long volume) {
		this.isBuy = isBuy;
		this.price = price;
		this.volume = volume;
	}
}