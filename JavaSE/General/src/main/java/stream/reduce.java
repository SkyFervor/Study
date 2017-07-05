package stream;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by skyfervor
 * 2017/03/28 18:54
 */
public class reduce {
	public static void main(String[] args) {
		List<Double> list = new LinkedList<Double>() {
			{
				add(1.1);
				add(100.1);
				add(67.8);
			}
		};
		int sum = list.stream().mapToInt(e -> (e = e + 1).intValue()).reduce(1, (x, y) -> x + y);

		System.out.println(sum);
	}
}
