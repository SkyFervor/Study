package org.tarena.entity;

public class Dept {
	private int id;
	private String dname;

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

}
