package genericType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyfervor
 * 2017/06/14 21:22
 */
public class ContainsTest {
	public static void main(String[] args) {
		Map<Long, String> map = new HashMap<>();
		map.put(1L, "");

		int keyTest = 1;
		System.out.println(map.containsKey(keyTest));
		// Integer.equals(Long);
	}
}
