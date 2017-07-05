package tree;

import tree.BinaryTree.Node;

/**
 * 二叉树的序列化和反序列化
 */
public class Serialize {
	public static String serialize(Node node) {
		if (node == null)
			return "#,";

		StringBuilder s = new StringBuilder();
		s.append(node.value + ",");
		s.append(serialize(node.lchild));
		s.append(serialize(node.rchild));

		return s.toString();
	}

	static int i = 0;

	public static Node deserialize(String str) {
		if (str == null || str.length() == 0)
			return null;

		if (i == str.length())
			return null;

		String[] num = str.split(",");
		String s = num[i];
		i++;
		if (s.equals("#"))
			return null;

		Node node = new Node(Integer.parseInt(s));
		node.lchild = deserialize(str);
		node.rchild = deserialize(str);
		return node;
	}

	public static void main(String[] args) {
		BinarySortTree bst = new BinarySortTree();
		bst.insert(4);
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);

		String serialize = serialize(bst.root);
		BinarySortTree n_bst = new BinarySortTree(deserialize(serialize));

		System.out.println(serialize);
		n_bst.printPre();
	}
}
