package org.tarena.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String sname;
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

}
