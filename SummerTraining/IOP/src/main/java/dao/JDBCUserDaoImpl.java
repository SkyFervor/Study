package dao;

public class JDBCUserDaoImpl implements UserDao {

	@Override
	public boolean findUser(String username, String password) {
		String existsUser = "admin";
		String existsPassword = "admin";

		if (existsUser.equals(username) && existsPassword.equals(password))
			return true;
		return false;
	}

}
