package recursion;

/**
 * 合并两个已排序的链表
 */
public class MergeLinkedList {
	static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node mergeHead = null;
		if (head1.value < head2.value) {
			mergeHead = head1;
			head1.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			head2.next = merge(head1, head2.next);
		}
		return mergeHead;
	}

	public static void main(String[] args) {
		// head1={0,2,4,6,8}
		Node head1 = new Node(0);
		Node tmp1 = head1;
		for (int i = 2; i < 10; i += 2) {
			tmp1.next = new Node(i);
			tmp1 = tmp1.next;
		}

		// head2={1,3,5,7,9}
		Node head2 = new Node(1);
		Node tmp2 = head2;
		for (int i = 3; i < 10; i += 2) {
			tmp2.next = new Node(i);
			tmp2 = tmp2.next;
		}

		Node mergeHead1 = merge(null, null);
		printLinkedList(mergeHead1);

		Node mergeHead2 = merge(head1, null);
		printLinkedList(mergeHead2);

		Node mergeHead3 = merge(null, head2);
		printLinkedList(mergeHead3);

		Node mergeHead4 = merge(head1, head2);
		printLinkedList(mergeHead4);

	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
}
