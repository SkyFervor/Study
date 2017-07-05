package reflectionTools;

import java.util.ArrayList;

public class Test {
	int id;
	int value;

	public Test(int id, int value) {
		this.id = id;
		this.value = value;
	}

	public static void main(String[] args) throws NoSuchMethodException {
		ArrayList<Test> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
			list.add(new Test(i, i));

		// getComponentType()
		// 只能对 普通数组 使用
		// ClassAnalyzer.analyse(list.getClass().getComponentType()); // Error
		int[] array = new int[] { 1 };
		System.out.println(ClassAnalyzer.analyze(array.getClass().getComponentType()));

		System.out.println(ClassAnalyzer.analyze(Test.class));

		System.out.println("\n" + ObjectAnalyzer.analyze(list));

		Test[] arr = new Test[2];
		Test t = new Test(1, 1);
		arr[0] = t;
		arr[1] = t;
		System.out.println("\n" + ObjectAnalyzer.analyze(arr));
	}

}
