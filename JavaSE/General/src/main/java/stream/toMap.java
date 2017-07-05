package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by skyfervor
 * 2017/03/29 20:38
 */
public class toMap {
	public static void main(String[] args) {
		List<TestClass> list = new ArrayList<>();
		list.add(new TestClass("A", 1));
		list.add(new TestClass("A", 2));
		list.add(new TestClass("A", 3));
		list.add(new TestClass("B", 1));

		Map<String, Integer> map = list.stream()
				.collect(Collectors.toMap(TestClass::getName, TestClass::getValue,
						BinaryOperator.maxBy(Comparator.comparing(p -> p))));

		System.out.println(map);
	}
}
