package overload;

import java.util.Arrays;

/**
 * Created by skyfervor
 * 2017/04/17 14:26
 */
class VariableArgumentTest {
	public void f(int i, Character... c) {
		System.out.println("i=" + i + ", c=" + Arrays.toString(c));
	}

	public void f(Character... c) {
		System.out.println("c=" + Arrays.toString(c));
	}

	public static void main(String[] args) {
		VariableArgumentTest test = new VariableArgumentTest();
		test.f(1, '1');
		//f('1', '2'); // Compile rror
	}
}
