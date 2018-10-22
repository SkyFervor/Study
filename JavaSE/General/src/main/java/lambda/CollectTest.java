package lambda;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CollectTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		String[] ss = new String[]{"1", "2", "3"};
		String result = Arrays.stream(ss)
				.collect(Collectors.joining("|"));
		System.out.println(result);
	}
}
