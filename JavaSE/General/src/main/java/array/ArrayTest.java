package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuhaoz
 * 2017/07/03 15:30
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] intArray = new int[1];
		Object o = intArray;
		copyOf(intArray, Array.getLength(o));
	}

	public static Object copyOf(Object o, int newLength) {
		Class<?> clazz = o.getClass();
		if (!clazz.isArray()) {
			return Collections.emptyList();
		}
		Class<?> componentType = clazz.getComponentType();
		int length = Array.getLength(o);
		Object[] array = (Object[]) Array.newInstance(componentType, length);
		System.arraycopy(o, 0, array, 0, Math.min(length, newLength));
		return array;
	}
}
