package genericType;

/**
 * Created by shuhaoz
 * 2017/07/05 16:25
 */
public class GenericTranslateTest {
	public static void main(String[] args) {
		Generic<String> obj = new ChildGeneric();
		obj.set("test");
	}
}

class ChildGeneric extends Generic<String> {
	// 语法上正确覆盖了父类方法
	// 问题：类型擦除导致父类方法参数变成Object
	@Override
	void set(String s) {
		System.out.println("Child.set");
	}

	// 解决：编译器添加桥方法
	/*
	void set(Object o) {
		set((String) o);
	}
	*/

	@Override
	String get() {
		return null;
	}

	/*
	Object get() {
		return get();
	}
	*/
}
