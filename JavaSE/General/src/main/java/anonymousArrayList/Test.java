package anonymousArrayList;

import java.util.ArrayList;

import reflectionTools.ClassAnalyzer;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("serial")
		ArrayList<Integer> list = new ArrayList<Integer>() {
			// 构造块
			{
				add(1);
				add(2);
				add(3);
			}
		};

		for (Integer i : list) {
			System.out.println(i.intValue());
		}

		System.out.println(ClassAnalyzer.analyze(list.getClass()));
	}

}
