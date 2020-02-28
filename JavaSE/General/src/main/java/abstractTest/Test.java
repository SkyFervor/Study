package abstractTest;

import lombok.ToString;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		AbstractClass[] array = new AbstractClass[]{new ConcreteClass()};
		System.out.println(Arrays.toString(array));
	}

	@ToString
	private static abstract class AbstractClass {
	}

	@ToString(callSuper = true)
	private static class ConcreteClass extends AbstractClass {
	}
}
