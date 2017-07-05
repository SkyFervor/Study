package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import model.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao; // IOC/DI

	private String daoStatus;

	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;

	public void init() {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	public void add(User user) {
		userDao.save(user);
	}

	public String getDaoStatus() {
		return daoStatus;
	}

	public List<String> getList() {
		return list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public Set<String> getSet() {
		return set;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setDaoStatus(String daoStatus) {
		this.daoStatus = daoStatus;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	// 基于setter的依赖注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
