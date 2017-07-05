package string;

/**
 * Created by skyfervor
 * 2016/12/02 16:18
 */
public class ReplaceTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String regex = "[\\u0000-\\u0009\\u000b\\u000c\\u000e-\\u001f]";
		String old_s = "{'1':\r\n '123aAzZskyfervor\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\u0008\u0009\u000b\u000c\u000e\u000f" +
				"\u0010\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u0010\u001a\u001b\u001c\u001d\u001e\u001f" +
				"~!@#$%^&*()_+-=·{}【】|、：“；‘《》，。、？ \"/\\♂♀";
		String new_s = old_s.replaceAll(regex, "");
		long end = System.currentTimeMillis();

		System.out.println(old_s);
		System.out.println(new_s);
		System.out.println("Take " + Float.toString((end - start)/1000F) + " seconds");
	}
}
