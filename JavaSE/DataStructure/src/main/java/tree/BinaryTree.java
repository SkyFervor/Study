package tree;

/**
 * 二叉树
 */
public class BinaryTree {
	public static class Node {
		public int value;
		public Node lchild;
		public Node rchild;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node root;

	public BinaryTree() {
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public void printIn() {
		printIn(root);
		System.out.println();
	}

	void printIn(Node node) {
		if (node == null)
			return;

		printIn(node.lchild);
		System.out.print(node.value + " ");
		printIn(node.rchild);
	}

	public void printPre() {
		printPre(root);
		System.out.println();
	}

	void printPre(Node node) {
		if (node == null)
			return;

		System.out.print(node.value + " ");
		printPre(node.lchild);
		printPre(node.rchild);
	}
}
