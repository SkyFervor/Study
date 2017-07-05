package list;

import java.util.HashSet;

import list.LinkedList.Node;

/**
 * 查找链表中环的入口节点
 */
public class EntryNodeOfLoop {
	// 空间复杂度O(n)
	// 使用Hash表保存访问过的节点，当前节点已存在于Hash表中时，该节点为环入口
	public static Node entryNodeOfLoop1(Node head) {
		HashSet<Node> set = new HashSet<>();
		Node node = head;
		while (node != null) {
			if (set.contains(node))
				return node;

			set.add(node);
			node = node.next;
		}
		char c = 0;
		System.out.println(c);
		return null;
	}

	// 空间复杂度O(1)
	// 节点p1、p2都指向头节点，p1每走一步，p2走两步，直到p1和p2相遇
	// 设p1走了x，则p2走了2x，p2比p1多走了一个环的长度n
	// 2x=x+n --> x=n --> n1从头节点开始，走了一个环的长度
	// 将p2重置为头节点，再和p1一起每次走一步，则相遇时的位置就是环的入口
	public static Node entryNodeOfLoop2(Node head) {
		Node p1 = head;
		Node p2 = head;

		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			System.out.println(p1.value + " " + p2.value);

			if (p1 == p2)
				break;
		}
		if (p2 == null || p2.next == null)
			return null;

		p2 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Node entry = list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.addLast(9);
		list.addLast(10);
		Node node = list.addLast(11);
		node.next = entry;

		list.print(12);
		System.out.println(entryNodeOfLoop1(list.head).value);
		System.out.println(entryNodeOfLoop2(list.head).value);
	}
}
