package question.qunar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入三列
 * 第一列：线程id
 * 第二列：线程所持有的锁列表，用逗号隔开
 * 第三列：线程所申请的锁
 * 每列用制表符隔开
 * 找形成死锁的线程组个数
 */
public class Test3 {
	static class Thread {
		String name;
		List<String> have = new ArrayList<String>();
		String require = null;
	}

	static List<Thread> threads = new ArrayList<Thread>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String[] info = scanner.nextLine().split("\t");

			Thread t = new Thread();
			t.name = info[0];

			if (!info[1].equals(" ")) {
				String[] have = info[1].split(",");
				for (String s : have)
					t.have.add(s);
			}

			if (!info[2].equals(" "))
				t.require = info[2];

			threads.add(t);
		}
		scanner.close();

		int num = 0;
		for (int i = 0; i < threads.size(); i++) {
			int j = i;
			while (j != -1) {
				Thread cur = threads.get(j);

				// 不请求锁的线程，不会形成死锁
				if (cur.require == null)
					break;

				j = findLock(cur.require, i);

				// 锁的占用-需求又回到起始线程，形成死锁
				if (i == j) {
					num++;
					break;
				}
			}
		}
		System.out.println(num);

		// Test3_2.deadLock();
	}

	/**
	 * 查找拥有指定锁的线程
	 * 
	 * @param lock
	 * @param start
	 * @return
	 */
	public static int findLock(String lock, int start) {
		for (int i = start; i < threads.size(); i++) {
			Thread t = threads.get(i);
			for (String s : t.have)
				if (s.equals(lock))
					return i;
		}
		return -1;
	}
}

/**
 * 第二种解法
 */
class Test3_2 {
	public static int deadLock() {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		// HashMap存储Occupy-Require关系
		Map<String, String> orm = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String[] info = scanner.nextLine().split("\t");

			if (!info[1].equals(" ") && !info[2].equals(" ")) {
				String[] have = info[1].split(",");
				for (String s : have)
					orm.put(s, info[2]);
			}
		}
		scanner.close();

		int num = 0;
		Iterator<String> it = orm.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String temp = key;
			// 查找循环条件
			do {
				temp = orm.get(temp);
				if (temp == key) {
					num++;
					it.remove();
					break;
				}
			} while (temp != null);
		}

		return num;
	}
}
