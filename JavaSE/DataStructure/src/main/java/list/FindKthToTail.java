package list;

import list.LinkedList.Node;

/**
 * 链表倒数第k个节点
 */
public class FindKthToTail {

	public static Node findKthToTail(Node head, int k) {
		if (k <= 0 || head == null)
			return null;

		Node node = head;
		while (--k != 0) {
			node = node.next;
			if (node == null)
				return null;
		}
		while (node.next != null) {
			node = node.next;
			head = head.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		Node head = new Node(array[0]);
		for (int i = array.length - 1; i > 0; i--) {
			Node node = new Node(array[i]);
			node.next = head.next;
			head.next = node;
		}

		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();

		System.out.println(findKthToTail(head, 6));
	}
}
