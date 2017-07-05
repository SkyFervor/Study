package json;

import com.alibaba.fastjson.JSON;

/**
 * Created by skyfervor
 * 2016/12/08 14:31
 */
public class Test {
	public static void main(String[] args) {
		String jsonString = "{\"info\" : {\"username\" : \"test\", \"password\" : \"test\", \"token\" : \"test\"}}";
		User user = JSON.parseObject(jsonString, User.class);
		System.out.println(user);
	}
}

class User {

	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	class Info {
		private String username;
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Info{" +
					"username='" + username + '\'' +
					", password='" + password + '\'' +
					'}';
		}
	}

	@Override
	public String toString() {
		return "User{" +
				"info=" + info +
				'}';
	}
}
