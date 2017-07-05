package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by skyfervor
 * 2017/03/30 11:18
 */
public class groupingBy {
	public static void main(String[] args) {
		List<TestClass> list = new ArrayList<>();
		list.add(new TestClass("A", 1, "group1"));
		list.add(new TestClass("A", 2, "group2"));
		list.add(new TestClass("A", 3, "group1"));
		list.add(new TestClass("B", 1, "group1"));
		list.add(new TestClass("B", 2, "group1"));
		list.add(new TestClass("C", 1, "group2"));


		Map<String, Map<String, List<TestClass>>> map = list.stream()
				.collect(Collectors.groupingBy(TestClass::getName, Collectors.groupingBy(TestClass::getAuthor)));
		System.out.println(map);
	}
}
