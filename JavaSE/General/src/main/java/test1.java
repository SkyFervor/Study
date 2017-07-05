import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by skyfervor
 * 2017/03/22 14:58
 */
public class test1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(2);
			}
		};

		System.out.println(list);
		list = list.parallelStream().sorted().collect(Collectors.toList());
		System.out.println(list);
	}
}
