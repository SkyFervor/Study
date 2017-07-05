package org.tarena.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

@Controller
public class EmpController {
	@Resource(name = "empDao")
	private EmpDao empDao;

	@RequestMapping("/add")
	public String add(HttpServletRequest request) throws SQLException {
		String ename = request.getParameter("ename");
		BigDecimal salary = new BigDecimal(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setAge(age);

		empDao.saveEmp(emp);

		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request) throws SQLException {
		List<Emp> emps = empDao.listEmp();
		request.setAttribute("emps", emps);

		return "forward:/listEmp.jsp";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));

		empDao.deleteEmpById(id);

		return "redirect:/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));

		Emp emp = empDao.findEmpById(id);
		request.setAttribute("emp", emp);

		return "forward:/updateEmp.jsp";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ename = request.getParameter("ename");
		BigDecimal salary = new BigDecimal(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		Emp emp = new Emp();
		emp.setId(id);
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setAge(age);

		empDao.updateEmp(emp);

		return "redirect:/list";
	}
}
