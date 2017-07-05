package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
	public static final String IP = "10.2.20.54";
	public static final String PORT = "1521";
	public static final String NAME = "orcl";
	public static final String URL = "jdbc:oracle:thin:@" + IP + ":" + PORT + ":" + NAME;
	public static final String USERNAME = "system";
	public static final String PASSWORD = "oracle";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement("select sysdate from dual");
			if (stmt.execute()) {
				System.out.println("连接成功");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("连接失败");
	}
}
