package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.dao.UserDao;
import com.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(User user) {
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into user values(null,?)");
			ps.setString(1, user.getUsername());
			ps.execute();
			System.out.println("a user saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
