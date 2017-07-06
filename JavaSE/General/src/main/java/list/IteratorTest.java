package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shuhaoz
 * 2017/07/06 13:18
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);

		Iterator<Integer> it1 = list.listIterator();
		for (int i = 0; i < 6; i++) {
			if (it1.hasNext()) {
				System.out.println(it1.next());
			}
		}

		System.out.println();
		Iterator<Integer> it2 = list.listIterator();
		for (int i = 0; i < 3; i++) {
			if (it2.hasNext()) {
				System.out.println(it2.next());
			}
		}

		it1.remove();
		while (it2.hasNext()) {
			// it1修改了集合，it2已失效，不应继续使用
			System.out.println(it2.next()); // Exception
		}
	}
}
