package genericType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetGenericTypeTest {

	public static List<String> list = new ArrayList<>();

	/**
	 * 获取泛型类型
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException,
			NoSuchFieldException, ClassNotFoundException {
		for (int i = 1; i <= 5; i++)
			list.add(String.valueOf(i));

		// --------------------------- 方法一 ---------------------------
		/*
		 * 利用 反射，通过ArrayList的get方法的返回值类型，间接获取ArrayList的泛型参数类型
		 * 由于泛型的 类型擦除，原始类型中的get方法返回类型为Object
		 * 故只会返回"Object"，不能满足要求
		 */
		Method method = list.getClass().getMethod("get", int.class);
		System.out.println(method.getReturnType().getSimpleName());
		// ------------------------- 方法一 END -------------------------

		// --------------------------- 方法二 ---------------------------
		/*
		 * 利用 反射，通过list对象对应Field的Type信息获取泛型类型
		 * Type中保存了实际的对象类型，包含类型参数信息
		 * 故能满足要求
		 */
		Field field = GetGenericTypeTest.class.getField("list"); // 获取list对象Field

		// 获取Field的Type
		// 注：此方法返回Type，getType()返回Class<?>
		// 后者是实际的Class对象故没有参数类型信息
		Type type_generic = field.getGenericType();
		System.out.println(type_generic.getTypeName());

		ParameterizedType pt = (ParameterizedType) type_generic; // 转换为参数化Type类型
		System.out.println(pt.getTypeName());

		Type[] type_actual_arr = pt.getActualTypeArguments();// Type中的类型参数信息列表
		System.out.println(type_actual_arr[0].getTypeName());
		// ------------------------- 方法二 END -------------------------

	}

}
