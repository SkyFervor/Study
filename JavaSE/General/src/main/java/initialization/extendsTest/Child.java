package initialization.extendsTest;

/**
 * Created by skyfervor
 * 2017/06/09 18:57
 */
public class Child extends Super {

	static int staticValue = print(3);

	static {
		print(4);
	}

	int value = print(8);
	{
		print(9);
	}

	Child() {
		print(10);
	}

	public static void main(String[] args) {
		new Child();
	}
}
