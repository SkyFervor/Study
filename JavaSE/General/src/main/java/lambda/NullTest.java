package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NullTest {

	public static void main(String[] args) {
		Entity e1 = new Entity();
		List<Entity> list = Arrays.asList(e1, null);

		List<Integer> keyList = list.stream()
				.filter(Objects::nonNull)
				.filter(e -> e.getKey() == 1)
				.map(Entity::getKey)
				.collect(Collectors.toList());
		System.out.println(keyList);
	}
}
