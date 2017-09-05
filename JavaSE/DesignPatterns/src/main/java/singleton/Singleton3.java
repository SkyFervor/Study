package singleton;

/**
 * Created by shuhaoz
 * 2017/07/12 14:53
 */
public class Singleton3 {
	private Singleton3() {}
	private static Singleton3 instance;
	public static synchronized Singleton3 getInstance() {
		if (instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}

	private String str = "test";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static void main(String[] args) {
		System.out.println(Singleton3.getInstance().getStr());
	}
}
