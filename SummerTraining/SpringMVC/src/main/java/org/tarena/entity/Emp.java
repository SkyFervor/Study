package org.tarena.entity;

import java.math.BigDecimal;

public class Emp {
	private int id;
	private String ename;
	private BigDecimal salary;
	private int age;
	private Dept dept;

	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", salary=" + salary + ", age=" + age
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
