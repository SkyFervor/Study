import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/spring";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		
		try(Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));	
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
