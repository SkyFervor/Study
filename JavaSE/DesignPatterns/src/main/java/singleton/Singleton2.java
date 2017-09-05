package singleton;

/**
 * Created by shuhaoz
 * 2017/07/12 14:45
 */
public class Singleton2 {
	private Singleton2() {}
	private static final Singleton2 INSTANCE = new Singleton2();
	public static Singleton2 getInstance() {
		return INSTANCE;
	}

	private String str = "test";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static void main(String[] args) {
		System.out.println(Singleton2.getInstance().getStr());
	}
}
