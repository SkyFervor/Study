package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shuhaoz on 2017/8/3 00003.
 */
public class CollectorsGroupingByTest {

	static class Entity {
		int value;
		int name;

		Entity() {
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
		List<Entity> entityList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				Entity entity = new Entity();
				entity.setValue(i);
				entity.setName(j);
				entityList.add(entity);
			}
		}

		Map<Integer, List<Integer>> map = test1(entityList);
		List<List<Integer>> list = test2(entityList);
		map.clear();
		list.clear();

		List<List<Integer>> list1 = test2(entityList);
		Map<Integer, List<Integer>> map1 = test1(entityList);
		map1.clear();
		list1.clear();

	}

	static Map<Integer, List<Integer>> test1(List<Entity> entityList) {
		List<Entity> testList = new ArrayList<>(entityList);

		long startTime = System.nanoTime();
		Map<Integer, List<Integer>> map = testList.stream().
				collect(Collectors.groupingBy(Entity::getValue, Collectors.mapping(Entity::getName, Collectors.toList())));
		System.out.println(System.nanoTime() - startTime);
		return map;
	}

	static List<List<Integer>> test2(List<Entity> entityList) {
		List<Entity> testList = new ArrayList<>(entityList);
		List<List<Integer>> result = new ArrayList<>();

		long startTime = System.currentTimeMillis();
		Map<Integer, List<Entity>> map1 = testList.stream().collect(Collectors.groupingBy(Entity::getValue));
		for (List<Entity> list : map1.values()) {
			List<Integer> tempList = list.stream().map(Entity::getName).collect(Collectors.toList());
			result.add(tempList);
		}
		System.out.println(System.nanoTime() - startTime);
		return result;
	}

}
