package org.tarena.dao.jdbc.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;
import org.tarena.util.DBUtil_Pool;

public class JDBCEmpDaoImpl implements EmpDao {

	@Override
	public void saveEmp(Emp emp) throws SQLException {
		Connection conn = DBUtil_Pool.getConnection();

		String sql = "insert into t_emp(ename,salary,age) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setBigDecimal(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.executeUpdate();

		conn.close();
	}

	@Override
	public List<Emp> listEmp() throws SQLException {
		Connection conn = DBUtil_Pool.getConnection();

		String sql = "select id,ename,salary,age from t_emp";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Emp> emps = new ArrayList<Emp>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String ename = rs.getString("ename");
			BigDecimal salary = rs.getBigDecimal("salary");
			int age = rs.getInt("age");

			Emp emp = new Emp();
			emp.setId(id);
			emp.setEname(ename);
			emp.setSalary(salary);
			emp.setAge(age);

			emps.add(emp);
		}

		conn.close();
		return emps;
	}

	@Override
	public void deleteEmpById(int id) throws SQLException {
		Connection conn = DBUtil_Pool.getConnection();

		String sql = "delete from t_emp where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();

		conn.close();
	}

	@Override
	public Emp findEmpById(int id) throws SQLException {
		Connection conn = DBUtil_Pool.getConnection();

		String sql = "select id,ename,salary,age from t_emp where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Emp emp = null;
		if (rs.next()) {
			String ename = rs.getString("ename");
			BigDecimal salary = rs.getBigDecimal("salary");
			int age = rs.getInt("age");

			emp = new Emp();
			emp.setId(id);
			emp.setEname(ename);
			emp.setSalary(salary);
			emp.setAge(age);
		}

		conn.close();
		return emp;
	}

	@Override
	public void updateEmp(Emp emp) throws SQLException {
		Connection conn = DBUtil_Pool.getConnection();

		String sql = "update t_emp set ename=?,salary=?,age=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setBigDecimal(2, emp.getSalary());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getId());
		ps.executeUpdate();

		conn.close();
	}
}
