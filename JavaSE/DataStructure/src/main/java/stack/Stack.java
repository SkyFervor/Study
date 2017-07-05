package stack;

public class Stack<E> {
	Object[] ele;
	int size;
	int top = -1;

	public Stack(int size) {
		this.size = size;
		ele = new Object[size];
	}

	public boolean push(E e) {
		if (top + 1 == size)
			return false;
		ele[++top] = e;
		return true;
	}

	public E pop() {
		if (top == -1)
			return null;

		@SuppressWarnings("unchecked")
		E e = (E) ele[top];
		ele[top--] = null;
		return e;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(10);

		System.out.println(stack.pop());

		for (int i = 0; i < 11; i++)
			System.out.println(stack.push(i));

		for (int i = 0; i < 11; i++)
			System.out.println(stack.pop());
	}
}
