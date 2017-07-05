package org.tarena.entity;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int id;
	private String dname;
	private Set<Emp> emps = new HashSet<Emp>();

	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}
