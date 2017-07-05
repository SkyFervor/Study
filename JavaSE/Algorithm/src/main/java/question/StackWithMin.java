package question;

import java.util.Stack;

/**
 * 包含min方法的栈
 */
public class StackWithMin {
	private Stack<Integer> data = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();

	public void push(int e) {
		data.push(e);
		int tmp = min.peek();
		min.push(Math.min(e, tmp));
	}

	public int pop() {
		min.pop();
		return data.pop();
	}

	public int min() {
		return min.peek();
	}

}
