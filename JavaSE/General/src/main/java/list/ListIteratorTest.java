package list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by shuhaoz
 * 2017/07/06 13:18
 */
public class ListIteratorTest {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);

		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();
		if (it.hasPrevious()) {
			System.out.println(it.previous());
			it.remove();
			System.out.println(list);
			System.out.println(it.previous());
			it.remove();
			System.out.println(list);
			// it.remove(); // Exception
			System.out.println(it.previous());
		}
	}
}
