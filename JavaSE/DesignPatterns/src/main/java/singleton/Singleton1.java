package singleton;

/**
 * Created by shuhaoz
 * 2017/07/12 14:40
 */
public class Singleton1 {
	private Singleton1() {}
	private static class SingletonHolder {
		private static final Singleton1 INSTANCE = new Singleton1();
	}
	public static Singleton1 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private String str = "test";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static void main(String[] args) {
		System.out.println(Singleton1.getInstance().getStr());
	}
}
