package collection;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {

	public static void main(String[] args) {
		test1();
		testPutIfAbsent();
	}

	public static void test1() {
		List<Integer> allValues = new HashMap<Integer, List<Integer>>().values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(allValues);
	}

	public static void testPutIfAbsent() {
		Map<Integer, List<Integer>> map = new HashMap<>();

		List<Integer> value = map.putIfAbsent(1, new ArrayList<>());
		System.out.println(null != value && value.add(1));
		System.out.println(map);

		value = map.putIfAbsent(1, new ArrayList<>());
		System.out.println(null != value && value.add(1));
		System.out.println(map);
	}
}
