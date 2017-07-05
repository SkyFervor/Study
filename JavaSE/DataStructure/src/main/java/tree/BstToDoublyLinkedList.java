package tree;

import tree.BinaryTree.Node;

/**
 * 二叉排序树按照从小到大顺序转化为双向链表
 */
public class BstToDoublyLinkedList {
	static Node pre = null;

	// 中序遍历
	public static Node exchange(Node node) {
		if (node == null)
			return null;

		Node head = exchange(node.lchild);

		node.lchild = pre;

		if (pre == null)
			head = node;
		else
			pre.rchild = node;

		pre = node;
		exchange(node.rchild);
		return head;
	}

	public static void main(String[] args) {
		BinarySortTree bst = new BinarySortTree();
		bst.insert(10);
		bst.insert(6);
		bst.insert(8);
		bst.insert(4);
		bst.insert(14);
		bst.insert(12);
		bst.insert(16);

		Node head = exchange(bst.root);

		Node left = head;
		Node right = null;
		while (left != null) {
			System.out.print(left.value + " ");

			if (left.rchild == null)
				right = left;

			left = left.rchild;
		}
		System.out.println();

		while (right != null) {
			System.out.print(right.value + " ");

			right = right.lchild;
		}
	}
}
