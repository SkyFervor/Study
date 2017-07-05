package map;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		fun1();
	}

	/**
	 * 对比重写和不重写hashCode方法和equals方法时HashMap的使用情况
	 */
	public static void fun1() {
		// 未重写hashCode和equals方法
		class Class1 {
			@SuppressWarnings("unused")
			int i = 0;
		}

		// 重写了hashCode和equals方法
		class Class2 {
			int i = 0;

			@Override
			public boolean equals(Object o) {
				if (this == o)
					return true;

				if (o instanceof Class2) {
					Class2 other = (Class2) o;

					if (i == other.i)
						return true;
				}

				return false;
			}

			@Override
			public int hashCode() {
				return i * 31;
			}
		}

		// 未重写的对象放入map修改后再get
		Class1 obj1 = new Class1();
		Map<Class1, Integer> map1 = new HashMap<Class1, Integer>();
		map1.put(obj1, 1);
		System.out.print(map1.get(obj1));
		obj1.i = 1;
		System.out.println(" " + map1.get(obj1));

		// 重写了的对象放入map修改后再get
		Class2 obj2 = new Class2();
		Map<Class2, Integer> map2 = new HashMap<Class2, Integer>();
		map2.put(obj2, 1);
		System.out.print(map2.get(obj2));
		obj2.i = 1;
		System.out.println(" " + map2.get(obj2));

		// null-key
		System.out.print(map2.get(null));
		map2.put(null, 2);
		System.out.println(" " + map2.get(null));
	}
}
