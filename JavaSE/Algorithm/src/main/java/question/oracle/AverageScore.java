package question.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AverageScore {

	public AverageScore() {
	}

	public static Map<String, Integer> average(List<Student> students) {
		Map<String, ClassInfo> classes = new HashMap<String, ClassInfo>();
		for (Student s : students) {
			ClassInfo classInfo = classes.get(s.classNumber);

			if (classInfo == null)
				classInfo = new ClassInfo();

			classInfo.add(s.score);
			classes.put(s.classNumber, classInfo);
		}

		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Entry<String, ClassInfo> entry : classes.entrySet()) {
			ClassInfo classInfo = entry.getValue();
			result.put(entry.getKey(), classInfo.sum / classInfo.num);
		}
		return result;
	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			Student s = new Student();
			s.classNumber = "1";
			s.score = i;

			list.add(s);
		}

		System.out.println(average(list));
	}
}

class Student {
	public String classNumber;
	public int score;
}

class ClassInfo {
	public int num = 0;
	public int sum = 0;

	public void add(int score) {
		sum += score;
		num++;
	}
}