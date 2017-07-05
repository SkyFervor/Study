package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(User user) {
		String sql = "insert into t_user(account,password) values(?,?)";

		int result = 0;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User get(int id) {
		String sql = "select * from t_user where id=?";

		User user = null;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int update(User user) {
		String sql = "update t_user set password=?,name=?,age=?,sex=? where id=?";

		int result = 0;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getName());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getSex());
			ps.setInt(5, user.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
