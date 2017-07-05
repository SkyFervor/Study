package pojo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_group")
public class Group {
	private int id;
	private String name;
	private List<User> users = new LinkedList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
	// @OneToMany
	// @JoinColumn(name="groupId") // 此句在单向一对多关联时必加
	public List<User> getUsers() {
		return users;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
