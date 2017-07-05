package tree;

import tree.BinaryTree.Node;

/**
 * 根据先序和中序遍历结果重建二叉树
 */
public class ConstructBinaryTree {
	public static Node reConstructBinaryTree(int[] pre, int[] in) {
		return reFun(pre, 0, in, 0, in.length);
	}

	// 先序遍历
	public static Node reFun(int[] pre, int i, int[] in, int j, int k) {
		if (i >= pre.length || j >= k)
			return null;

		int index;
		for (index = j; index < k; index++) {
			if (in[index] == pre[i])
				break;
		}
		if (index == k)
			return null;

		Node node = new Node(pre[i]);
		node.lchild = reFun(pre, i + 1, in, j, index);
		node.rchild = reFun(pre, i + index - j + 1, in, index + 1, k);
		return node;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 3, 5, 6 };
		int[] in = { 4, 2, 1, 5, 3, 6 };
		Node root = reConstructBinaryTree(pre, in);
		BinaryTree bt = new BinaryTree(root);
		bt.printPre();
		bt.printIn();
	}
}
