package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		Entity e1 = new Entity(1, null, 1, null);
		Entity e2 = new Entity(2, 2, 2, null);

		List<Entity> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);

		list.sort(Comparator.comparing(Entity::getValue, Comparator.nullsLast(Integer::compareTo)));
		System.out.println(list);
	}
}
