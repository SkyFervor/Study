package lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shuhaoz on 2017/8/3 00003.
 */
public class CollectorsGroupingByTest {

	static class Entity {
		int value;
		int name;

		Entity(int value, int name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getName() {
			return name;
		}

		public void setName(int name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		List<Entity> entityList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				Entity entity = new Entity(random.nextInt(100), j);
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

	public static Map<Integer, List<Integer>> test1(List<Entity> entityList) {
		return entityList.stream().
				collect(Collectors.groupingBy(Entity::getValue, Collectors.mapping(Entity::getName, Collectors.toList())));
	}

	public static Map<Integer, List<Integer>> test2(List<Entity> entityList) {
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
