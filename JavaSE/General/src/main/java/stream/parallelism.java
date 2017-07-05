package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyfervor
 * 2017/03/29 20:22
 */
public class parallelism {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i< 100; i++) {
			list.add(i);
		}

		list.parallelStream().forEach(System.out::println);
	}
}
