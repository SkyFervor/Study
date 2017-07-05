package dao.c3p0.noconfig;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/forum";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static ComboPooledDataSource dataSource = null;

	static {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(DRIVER);
			dataSource.setJdbcUrl(URL);
			dataSource.setUser(USERNAME);
			dataSource.setPassword(PASSWORD);

			dataSource.setInitialPoolSize(2);
			dataSource.setMinPoolSize(1);
			dataSource.setMaxPoolSize(10);
			dataSource.setMaxStatements(50);
			dataSource.setMaxIdleTime(60);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	private C3P0Util() {
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
