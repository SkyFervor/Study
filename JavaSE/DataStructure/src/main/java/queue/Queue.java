package queue;

public class Queue<E> {
	Node<E> head;
	Node<E> tail;

	public void offer(E e) {
		if (tail == null) {
			tail = new Node<E>(e);
			head = tail;
		} else {
			tail.next = new Node<E>(e);
			tail = tail.next;
		}
	}

	public E poll() {
		if (head == null)
			return null;
		E e = head.value;
		head = head.next;
		if (head == null)
			tail = null;
		return e;
	}

	class Node<T> {
		T value;
		Node<T> next;

		public Node(T t) {
			value = t;
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		System.out.println(queue.poll());

		for (int i = 0; i < 10; i++)
			queue.offer(i);

		for (int i = 0; i < 11; i++)
			System.out.println(queue.poll());

	}
}
