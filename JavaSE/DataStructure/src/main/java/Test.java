import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) throws IOException {
		Collection<Integer> collection;

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		Stack<Integer> stack = new Stack<Integer>();

		ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>(20);
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<Integer, Integer>();

		HashSet<Integer> hashSet = new HashSet<Integer>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		Long.toBinaryString(0);
		Arrays.sort(new int[0]);
		int i = 2, j = 0;
		j = 5 * ++i;
		System.out.println(j + " " + i);

		int a = 1, b = 3, c = 5;
		System.out.println(++a + b++ + c++);

		System.out.println(1 / 3 * 3);

		int x = 1, y = 2;
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println(x + " " + y);

		String s1 = "13", s2 = "7";
		System.out.println(s1.compareTo(s2));

		Collections.binarySearch(arrayList, 1);
		Collections.sort(arrayList);
		Collections.copy(arrayList, linkedList);
		Collections.addAll(arrayList, new Integer[] {});
		Arrays.binarySearch(new Integer[] {}, 1);
		Arrays.sort(new Integer[] {});
		Arrays.copyOf(new int[] {}, 1);
		Arrays.asList(new Integer[] {});

		System.out.println(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(new int[] { 1, 2, 3 }));

		List<String> list_s = new ArrayList<>();
		List<Object> list_o = (List<Object>) (List) list_s;

		int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
		int[] in = { 3, 2, 4, 1, 6, 5, 7 };
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.println(root.val);
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reCon(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public static TreeNode reCon(int[] pre, int sp, int ep, int[] in, int si, int ei) {
		if (sp > ep || si > ei)
			return null;
		if (sp == ep)
			return new TreeNode(pre[sp]);

		TreeNode node = new TreeNode(pre[sp]);
		int i = findParent(in, pre[sp]);
		node.left = reCon(pre, sp + 1, i, in, 0, i - 1);
		node.right = reCon(pre, i + 1, ep, in, i + 1, ei);

		return node;
	}

	public static int findParent(int[] in, int val) {
		for (int i = 0; i < in.length; i++) {
			if (in[i] == val)
				return i;
		}
		return -1;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
