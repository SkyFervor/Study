package map;

import java.util.TreeMap;

/**
 * Created by shuhaoz
 * 2017/07/11 21:05
 */
public class TreeMapTest {
	static class Test {
		int i;

		public Test(int i) {
			this.i = i;
		}
	}

	public static void main(String[] args) {
		Test test = new Test(1);
		TreeMap<Test, String> map = new TreeMap<>();
		map.put(test, "test");
	}
}

