package leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 按K个节点一组翻转链表
 */
public class ReverseNodesInKGroupV2 {

    private static String SPLITER = " ";

    private static class Node {
        Node next;
        String value;
    }

    private static Node reverseLinkedList(Node first, int k) {
        Node newStart = new Node();
        Node pre = newStart;
        while (null != first) {
            pre = reverseKNodes(pre, first, k);
            first = pre.next;
        }
        return newStart.next;
    }

    private static Node reverseKNodes(Node pre, Node first, int k) {
        Deque<Node> stack = new LinkedList<>();
        Node next = first;
        for (int i = 0; i < k; i++) {
            if (null == next) {
                break;
            }
            stack.push(next);
            next = next.next;
        }

        Node last = stack.pop();
        Node start = last;
        while (!stack.isEmpty()) {
            last.next = stack.pop();
            last = last.next;
        }
        last.next = next;
        pre.next = start;
        return last;
    }

    public static void main(String[] args) {
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
