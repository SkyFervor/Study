package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.HibernateUtil;

public class TreeNodeTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		try {
			sf = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

	@Test
	public void testTree() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(initTree());
		session.getTransaction().commit();

		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		TreeNode rootNode = (TreeNode) session2.load(TreeNode.class, 1);
		System.out.print(getTree(rootNode));
		session2.getTransaction().commit();
	}

	private TreeNode initTree() {
		// 根
		TreeNode rootNode = new TreeNode("root");

		// 一级
		TreeNode node0 = new TreeNode("Michael");
		node0.setParent(rootNode);
		rootNode.getChildren().add(node0);

		// 二级
		TreeNode node0_0 = new TreeNode("J2EE");
		node0_0.setParent(node0);
		node0.getChildren().add(node0_0);
		// 二级
		TreeNode node0_1 = new TreeNode("SOA");
		node0_1.setParent(node0);
		node0.getChildren().add(node0_1);
		// 二级
		TreeNode node0_2 = new TreeNode("NoSQL");
		node0_2.setParent(node0);
		node0.getChildren().add(node0_2);

		// 二级
		TreeNode node0_3 = new TreeNode("编程语言");
		node0_3.setParent(node0);
		node0.getChildren().add(node0_3);

		// 三级
		TreeNode node0_3_0 = new TreeNode("Java");
		node0_3_0.setParent(node0_3);
		node0_3.getChildren().add(node0_3_0);

		TreeNode node0_3_1 = new TreeNode("Groovy");
		node0_3_1.setParent(node0_3);
		node0_3.getChildren().add(node0_3_1);

		TreeNode node0_3_2 = new TreeNode("JS");
		node0_3_2.setParent(node0_3);
		node0_3.getChildren().add(node0_3_2);

		// 一级
		TreeNode node1 = new TreeNode("Hazel");
		node1.setParent(rootNode);
		rootNode.getChildren().add(node1);
		// 二级
		TreeNode node1_0 = new TreeNode("life");
		node1_0.setParent(node1);
		node1.getChildren().add(node1_0);
		// 二级
		TreeNode node1_1 = new TreeNode("美食");
		node1_1.setParent(node1);
		node1.getChildren().add(node1_1);
		// 二级
		TreeNode node1_2 = new TreeNode("旅游");
		node1_2.setParent(node1);
		node1.getChildren().add(node1_2);

		return rootNode;
	}

	private String getTree(TreeNode root) {
		StringBuilder result = new StringBuilder("\nid\tvalue\tparent_id\n");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			result.append(node.getId() + "\t" + node.getValue() + "\t");
			TreeNode parent = node.getParent();
			if (parent != null)
				result.append(parent.getId());
			result.append("\n");

			Set<TreeNode> children = node.getChildren();
			for (TreeNode child : children)
				queue.offer(child);
		}
		return result.toString();
	}
}
