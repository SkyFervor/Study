package map;

public class Resize {
	static class Node {
		int value;
		Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public final int getValue() {
			return value;
		}
	}

	/**
	 * 调试观察HashMap.resize()的流程
	 */
	public static void main(String[] args) {
		Integer[][] input = { { 1, 2, 3, 4, 5 }, { 6, 7 }, { 8, 9, 10 } };
		Node[] table = new Node[input.length];
		for (int i = 0; i < input.length; i++) {
			Integer[] nums = input[i];
			Node next = null;
			for (int j = nums.length - 1; j >= 0; j--) {
				Node node = new Node(nums[j], next);
				next = node;
			}
			table[i] = next;
		}

		printTable(table);
		Node[] newTable = resize(table);
		printTable(newTable);
	}

	public static Node[] resize(Node[] oldTab) {
		int oldCap = oldTab.length;
		int newCap = oldCap * 2;
		Node[] newTab = new Node[newCap];
		for (int j = 0; j < oldCap; ++j) {
			Node e;
			if ((e = oldTab[j]) != null) {
				oldTab[j] = null;
				if (e.next == null)
					newTab[j] = e;
				else { // preserve order
					Node head = null, tail = null;
					Node next;
					do {
						next = e.next;
						if (tail == null)
							head = e;
						else
							tail.next = e;
						tail = e;
					} while ((e = next) != null);
					if (tail != null) {
						tail.next = null;
						newTab[j + oldCap] = head;
					}
				}
			}
		}
		return newTab;
	}

	public static void printTable(Node[] table) {
		System.out.println();
		for (Node node : table) {
			while (true) {
				if (node == null) {
					System.out.print("null");
					break;
				}

				System.out.print(node.getValue() + " ");
				node = node.next;
			}
			System.out.println();
		}
	}
}
