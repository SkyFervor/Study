package question.qihu360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * 统计同乡数量
 * 第一行输入总人数n、关系数量m
 * 输入m行，每行a、b表示两者为同乡
 * 输出1的同乡有多少人
 * 
 * 输入为0 0时结束
 */
public class Test2 {
	public static void main(String[] args) {
		// 输入
		Scanner scanner = new Scanner(System.in);
		int n, m;
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			if (n == 0 && m == 0)
				break;

			int[][] rel = new int[m][2];// 用二维数组存储同乡关系
			for (int i = 0; i < m; i++) {
				rel[i][0] = scanner.nextInt();
				rel[i][1] = scanner.nextInt();
			}

			results.add(getRelation(n, rel));
		}
		scanner.close();

		// 输出
		for (Integer result : results)
			System.out.println(result);
	}

	public static int getRelation(int n, int[][] rel) {
		Set<Integer> r = new HashSet<Integer>(); // 存放“1”的同乡
		r.add(1);
		Queue<Integer> queue = new LinkedList<Integer>(); // 扫描队列
		queue.offer(1);
		while (!queue.isEmpty()) {
			int id = queue.poll();
			// 遍历关系数组，查找未被统计过的关系，加入队列和集合
			for (int i = 0; i < rel.length; i++) {
				if (id == rel[i][0] && !r.contains(rel[i][1])) {
					queue.offer(rel[i][1]);
					r.add(rel[i][1]);
				} else if (id == rel[i][1] && !r.contains(rel[i][0])) {
					queue.offer(rel[i][0]);
					r.add(rel[i][0]);
				}
			}
		}
		return r.size() - 1;
	}
}
