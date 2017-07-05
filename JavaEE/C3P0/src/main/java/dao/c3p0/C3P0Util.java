package dao.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	private C3P0Util() {
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
