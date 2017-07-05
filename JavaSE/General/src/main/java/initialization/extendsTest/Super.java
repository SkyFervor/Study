package initialization.extendsTest;

/**
 * Created by skyfervor
 * 2017/06/09 18:57
 */
public class Super {

	static int staticValue = print(1);
	static {
		print(2);
	}

	int value = print(5);
	{
		print(6);
	}

	Super() {
		print(7);
	}

	public static int print(int value) {
		System.out.println(value);
		return value;
	}
}
