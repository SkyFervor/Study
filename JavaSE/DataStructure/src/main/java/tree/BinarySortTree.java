package tree;

/**
 * 二叉排序树
 */
public class BinarySortTree extends BinaryTree {
	public BinarySortTree() {
	}

	public BinarySortTree(Node root) {
		this.root = root;
	}

	public void insert(int n) {
		if (root != null)
			insert(root, n);
		else {
			root = new Node(n);
		}
	}

	void insert(Node node, int n) {
		if (node == null)
			return;

		if (n < node.value) {
			if (node.lchild == null) {
				node.lchild = new Node(n);
				return;
			}

			insert(node.lchild, n);
		} else if (n > node.value) {
			if (node.rchild == null) {
				node.rchild = new Node(n);
				return;
			}

			insert(node.rchild, n);
		}
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
		bst.printIn();
	}
}
