package overload;

/**
 * Created by skyfervor
 * 2017/04/17 14:26
 */
class VariableArgumentTest {
	public static void f(int i, Character... c) {
		System.out.println(i + ": " + c);
	}

	public static void f(Character... c) {
		System.out.println(c);
	}

	public static void main(String[] args) {
		// f(1, '1');
		// f('1', '2');
	}
}
