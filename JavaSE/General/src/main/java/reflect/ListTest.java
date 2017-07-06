package reflect;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by shuhaoz
 * 2017/07/06 17:00
 */
public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		TreeMap<String, String> map = new TreeMap<>();

		// entrySet()返回的是不可修改视图，任何写操作均会报异常
		System.out.println(map.entrySet().add(null)); // Exception
	}
}
