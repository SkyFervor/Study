package Tree;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TreeNode {
	private int id;
	private String value;
	private TreeNode parent;
	private Set<TreeNode> children = new HashSet<TreeNode>();

	public TreeNode() {

	}

	public TreeNode(String value) {
		this.value = value;
	}

	@OneToMany(mappedBy = "parent", cascade = { CascadeType.ALL })
	public Set<TreeNode> getChildren() {
		return children;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
	public TreeNode getParent() {
		return parent;
	}

	public String getValue() {
		return value;
	}

	public void setChildren(Set<TreeNode> children) {
		this.children = children;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
