package list;

public class LinkedList {
	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node head;
	public Node tail;

	public LinkedList() {
	}

	public LinkedList(Node head) {
		this.head = head;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node addFirst(int value) {
		if (isEmpty()) {
			head = new Node(value);
			tail = head;
		} else {
			Node node = new Node(value);
			node.next = head;
			head = node;
		}
		return head;
	}

	public Node addLast(int value) {
		if (isEmpty()) {
			tail = new Node(value);
			head = tail;
		} else {
			tail.next = new Node(value);
			tail = tail.next;
		}
		return tail;
	}

	public Node removeFirst() {
		if (isEmpty())
			return null;

		Node node = head;
		head = head.next;
		if (head == null)
			tail = null;
		return node;
	}

	public Node removeLast() {
		if (isEmpty())
			return null;

		Node node = tail;
		if (tail == head) {
			head = null;
			tail = null;
			return node;
		}

		Node pre = head;
		while (pre.next != null) {
			if (pre.next == tail)
				break;
			pre = pre.next;
		}
		pre.next = null;
		tail = pre;
		return node;
	}

	public void print(int item) {
		Node node = head;
		for (int i = 0; i < item; i++) {
			if (node == null)
				break;

			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
