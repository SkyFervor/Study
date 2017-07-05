package pojo;

import java.io.Serializable;

public class TeacherPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof TeacherPK) {
			TeacherPK pk = (TeacherPK) obj;
			if (id == pk.getId() && name.equals(pk.getName()))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
