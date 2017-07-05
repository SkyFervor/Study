package stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by skyfervor
 * 2017/03/29 18:34
 */
public class map {
	private Integer value;

	public map(Integer value) {
		this.value = value;
	}

	public static void main(String[] args) {
		List<map> list = new LinkedList<>();
		list.add(new map(1));
		list.add(new map(2));
		list.add(new map(3));
		list.add(new map(1));

		List<Integer> newList = list.stream().map(t -> t.value).collect(Collectors.toList());
		System.out.println(newList);
	}
}
