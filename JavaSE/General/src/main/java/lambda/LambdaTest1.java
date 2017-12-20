package lambda;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by shuhaoz
 * 2017/07/04 18:05
 */
public class LambdaTest1 {
	public static void main(String[] args) {
		testJoining();
	}

	private static void testJoining() {
		Entity e1 = new Entity(1, 1, 1);
		Entity e2 = new Entity(2, 2, 2);
		Object[] keys = new Object[]{e1, e2};
		String result = Arrays.stream(keys)
				.map(Object::toString)
				.collect(Collectors.joining("-"));
		System.out.println(result);
	}
}
