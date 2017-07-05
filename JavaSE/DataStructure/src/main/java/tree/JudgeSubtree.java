package tree;

import tree.BinaryTree.Node;

/**
 * 判断一棵二叉树(tree2)是否是另一棵二叉树(tree1)的子树
 */
public class JudgeSubtree {

	public static boolean hasSubtree(Node tree1, Node tree2) {
		if (tree1 == null || tree2 == null)
			return false;

		boolean result = false;
		if (tree1.value == tree2.value)
			result = judge(tree1, tree2);
		if (!result)
			result = hasSubtree(tree1.lchild, tree2);
		if (!result)
			result = hasSubtree(tree1.rchild, tree2);
		return result;
	}

	public static boolean judge(Node tree1, Node tree2) {
		if (tree2 == null)
			return true;
		else if (tree1 == null)
			return false;
		if (tree1.value != tree2.value)
			return false;

		return judge(tree1.lchild, tree2.lchild) && judge(tree1.rchild, tree2.rchild);
	}

	public static void main(String[] args) {
		BinarySortTree bst1 = new BinarySortTree();
		bst1.insert(10);
		bst1.insert(6);
		bst1.insert(14);
		bst1.insert(4);
		bst1.insert(8);
		bst1.insert(12);
		bst1.insert(16);

		BinarySortTree bst2 = new BinarySortTree();
		bst2.insert(6);
		bst2.insert(4);
		bst2.insert(8);

		System.out.println(hasSubtree(bst1.root, bst2.root));
	}
}
