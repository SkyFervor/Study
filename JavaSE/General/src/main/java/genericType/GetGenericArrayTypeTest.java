package genericType;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by shuhaoz
 * 2017/07/05 20:34
 */
public class GetGenericArrayTypeTest {
	public static void main(String[] args) {
		GenericList list = new GenericList();
		Integer[] arr = list.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr));
	}

}

class GenericList {
	Object[] objects = {1, 2, 3};

	public <T> T[] toArray(T[] a) {
		int size = objects.length;
		if (a.length < size) {
			Class<?> newType = a.getClass();

			T[] copy = ((Object) a.getClass() == (Object) Object[].class)
					? (T[]) new Object[size]
					: (T[]) Array.newInstance(newType.getComponentType(), size);
			 System.arraycopy(objects, 0, copy, 0, size);
			 return copy;
		} else {
			System.arraycopy(objects, 0, a, 0, size);
			if (a.length > size) {
				a[size] = null;
			}
			return a;
		}
	}
}
