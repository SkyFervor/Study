package map;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		Boolean b = (map != null ? map.get("get") : false);
		System.out.println(b);
	}
}
