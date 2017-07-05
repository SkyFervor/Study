package org.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import org.tarena.entity.Emp;

public interface EmpDao {
	public void saveEmp(Emp emp) throws SQLException;

	public List<Emp> listEmp() throws SQLException;

	public void deleteEmpById(int id) throws SQLException;

	public Emp findEmpById(int id) throws SQLException;

	public void updateEmp(Emp emp) throws SQLException;

	public Emp findEmpByAccount(String account) throws SQLException;
}
