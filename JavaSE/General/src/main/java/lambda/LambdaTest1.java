package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by shuhaoz
 * 2017/07/04 18:05
 */
public class LambdaTest1 {
	public static void main(String[] args) {
		testJoining();
		testLimit();
	}

	private static void testJoining() {
		Entity e1 = new Entity(1, 1, 1);
		Entity e2 = new Entity(2, 2, 2);
		Object[] keys = new Object[]{null};
		String result = Arrays.stream(keys)
				.filter(Objects::nonNull)
				.map(Object::toString)
				.collect(Collectors.joining("-"));
		System.out.println(result);
	}

	private static void testLimit() {
		Entity e1 = new Entity(1, 1, 1);
		Entity e2 = new Entity(2, 2, 2);
		List<Entity> list = Arrays.asList(e1, e2, null, e1, null);

		String result;
		int firstNullIndex = list.indexOf(null);
		if (firstNullIndex != -1) {
			result = list.stream()
					.limit(firstNullIndex)
					.map(Object::toString)
					.collect(Collectors.joining("-"));
		} else {
			result = list.stream()
					.map(Object::toString)
					.collect(Collectors.joining("-"));
		}
		System.out.println(result);
	}
}
