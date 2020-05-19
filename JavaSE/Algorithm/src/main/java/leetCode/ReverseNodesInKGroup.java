package leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 按K个节点一组翻转链表
 */
public class ReverseNodesInKGroup {

	private static String SPLITER = " ";

	private static class Node {
		Node next;
		String value;
	}

	private static Node reverseLinkedList(Node head, int k) {
		Node newHead = new Node();
		Node pre = newHead;
		while (null != head) {
			pre = reverseKNodes(pre, head, k);
            if (null == pre) {
                break;
            }
			head = pre.next;
		}
		return newHead.next;
	}

	private static Node reverseKNodes(Node pre, Node head, int k) {
        Deque<Node> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (null == head) {
                break;
            }
            stack.push(head);
            head = head.next;
        }
        if (stack.size() < k) {
            return null;
        }

        Node start = stack.pop();
        pre.next = start;
        while (!stack.isEmpty()) {
            start.next = stack.pop();
            start = start.next;
        }
        start.next = head;
		return start;
	}

	public static void main(String[] args) {
        System.out.println(19/10);
		Scanner scanner = new Scanner(System.in);
		int k = Integer.parseInt(scanner.nextLine());
		String[] chain = scanner.nextLine().split(SPLITER);

		Node first = buildLinkedList(chain);
		printLinkedList(first);

		first = reverseLinkedList(first, k);
		printLinkedList(first);
	}

	private static Node buildLinkedList(String[] chain) {
		Node start = new Node();
		Node last = start;
		for (String value : chain) {
			Node newNode = new Node();
			newNode.value = value;
			last.next = newNode;

			last = newNode;
		}
		return start.next;
	}

	private static void printLinkedList(Node first) {
		StringBuilder result = new StringBuilder();
		Node cur = first;
		while (null != cur) {
			if (cur != first) {
				result.append(SPLITER);
			}
			result.append(cur.value);
			cur = cur.next;
		}
		System.out.println("LinkedList: " + result.toString());
	}

}
