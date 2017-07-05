package arrays;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		fun1();
	}

	/**
	 * 验证Arrays.copyOf()和System.arraycopy()是浅克隆
	 */
	public static void fun1() {
		class Class implements Cloneable {
			int a = 0;

			@Override
			public Object clone() throws CloneNotSupportedException {
				Class obj = (Class) super.clone();
				obj.a = a;
				return obj;
			}
		}

		Class obj = new Class();
		Class[] arr1 = new Class[1];
		arr1[0] = obj;
		System.out.println(arr1[0].a);

		Class[] arr2;
		arr2 = Arrays.copyOf(arr1, arr1.length);
		obj.a = 1;
		System.out.println(arr2[0].a);
		System.out.println(arr1[0] == arr2[0] ? "浅克隆" : "深克隆");
	}
}
