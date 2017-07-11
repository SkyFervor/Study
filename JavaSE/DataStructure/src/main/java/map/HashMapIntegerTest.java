package map;

import java.util.HashMap;

/**
 * Created by shuhaoz
 * 2017/07/11 20:30
 */
public class HashMapIntegerTest {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "test");

		System.out.println(map.get(1L));
	}
}
