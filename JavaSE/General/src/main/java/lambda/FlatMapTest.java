package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMapTest {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ChildEntity childEntity1 = new ChildEntity(1, 1);
		ChildEntity childEntity2 = new ChildEntity(2, 2);
		ChildEntity childEntity3 = new ChildEntity(3, 3);
		ChildEntity childEntity4 = new ChildEntity(4, 4);

		List<ChildEntity> childEntityList1 = Arrays.asList(childEntity1, childEntity2, childEntity3);
		List<ChildEntity> childEntityList2 = Arrays.asList(childEntity4);

		Entity entity1 = new Entity(11, 11, 11, childEntityList1);
		Entity entity2 = new Entity(22, 22, 22, childEntityList2);

		List<Entity> entityList = Arrays.asList(entity1, entity2);

		entityList.stream()
				.map(Entity::getChildEntities)
				.flatMap(Collection::stream)
				.map(ChildEntity::getKey)
				.forEach(System.out::println);
	}
}
