package org.tarena.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil_Pool {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/emp";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	private static ComboPooledDataSource pool;

	static {
		try {
			pool = new ComboPooledDataSource();
			pool.setJdbcUrl(URL);
			pool.setDriverClass(DRIVER);
			pool.setUser(USER);
			pool.setPassword(PASSWORD);

			pool.setInitialPoolSize(2);
			pool.setAcquireIncrement(2);
			pool.setMaxPoolSize(20);
			pool.setMinPoolSize(2);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = pool.getConnection();
		return conn;
	}
}
