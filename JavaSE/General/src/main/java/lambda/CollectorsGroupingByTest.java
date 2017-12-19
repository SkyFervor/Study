package lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shuhaoz on 2017/8/3 00003.
 */
public class CollectorsGroupingByTest {

	public static void main(String[] args) {
		Random random = new Random();
		List<Entity> entityList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				Entity entity = Entity.builder()
						.value(random.nextInt(100))
						.name(j)
						.build();
				entityList.add(entity);
			}
		}

		long startTime;

		startTime = System.nanoTime();
		Map<Integer, List<Integer>> map2 = test2(entityList);
		System.out.println(System.nanoTime() - startTime);

		startTime = System.nanoTime();
		Map<Integer, List<Integer>> map1 = test1(entityList);
		System.out.println(System.nanoTime() - startTime);

		map1.clear();
		map2.clear();

		startTime = System.nanoTime();
		map1 = test1(entityList);
		System.out.println(System.nanoTime() - startTime);

		startTime = System.nanoTime();
		map2 = test2(entityList);
		System.out.println(System.nanoTime() - startTime);

		map1.clear();
		map2.clear();
	}

	private static Map<Integer, List<Integer>> test1(List<Entity> entityList) {
		return entityList.stream().
				collect(Collectors.groupingBy(Entity::getValue, Collectors.mapping(Entity::getName, Collectors.toList())));
	}

	private static Map<Integer, List<Integer>> test2(List<Entity> entityList) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (Entity entity : entityList) {
			List<Integer> list = map.get(entity.getValue());
			if (list == null) {
				list = new ArrayList<>();
				list.add(entity.getName());
				map.put(entity.getValue(), list);
			} else {
				list.add(entity.getName());
			}
		}
		return map;
	}

}
