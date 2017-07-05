package question;

import java.util.LinkedList;

/**
 * 根据栈元素的压入序列，判断所给序列是否可能是弹出序列
 */
public class IsPopOrder {
	public static boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0)
			return false;

		LinkedList<Integer> stack = new LinkedList<>();
		int j = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);

			while (!stack.isEmpty() && j < popA.length && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		if (stack.isEmpty() && j == popA.length)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] push1 = { 1, 2, 3, 4, 5 };
		int[] pop1 = { 4, 5, 3, 2, 1 };
		System.out.println(isPopOrder(push1, pop1));

		int[] push2 = {};
		int[] pop2 = {};
		System.out.println(isPopOrder(push2, pop2));
	}
}
