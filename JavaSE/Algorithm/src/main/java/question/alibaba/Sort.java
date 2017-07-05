package question.alibaba;
/**
 * 数组中只有一个数重复了3次，其他数均只重复2次
 * 找出重复了3次的这个数
 */
public class Sort {

	// 节点
	static class Node {
		int value;
		int n = 1;
		Node lchild = null;
		Node rchild = null;

		public Node(int value) {
			this.value = value;
		}

		void setLChild(Node node) {
			lchild = node;
		}

		void setRchild(Node node) {
			rchild = node;
		}
	}

	/**
	 * 利用递归将新节点插入二叉排序树中正确位置
	 * 
	 * @param prt
	 *        当前节点的父节点
	 * @param curr
	 *        当前节点
	 * @param right
	 *        父子关系
	 * @param num
	 *        新节点的关键字
	 * @return
	 */
	public static Node insertBST(Node curr, int num) {
		// 值已存在
		if (num == curr.value) {
			curr.n++;
			if (curr.n == 3)
				return curr; // 重复次数已达3次，返回该节点
		}
		// 值小于当前节点，插入左子树
		else if (num < curr.value) {
			if (curr.lchild != null)
				return insertBST(curr.lchild, num);

			Node node = new Node(num);
			curr.lchild = node;
		}
		// 值大于当前节点，插入右子树
		else {
			if (curr.rchild != null)
				return insertBST(curr.rchild, num);

			Node node = new Node(num);
			curr.rchild = node;
		}
		return null;
	}

	/**
	 * 找数组中重复3次的数
	 * 其余数重复2次
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262 };

		// 插入建树
		Node tree = new Node(nums[0]);
		Node tmp = null;
		for (int i = 1; i < nums.length; i++) {
			tmp = insertBST(tree, nums[i]);
			if (tmp != null)
				break;
		}

		if (tmp == null)
			System.out.println("没有重复3次的数");
		else
			System.out.println("重复3次的数：" + tmp.value);
	}
}
