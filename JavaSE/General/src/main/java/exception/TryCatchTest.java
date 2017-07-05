package exception;

/**
 * Created by skyfervor
 * 2017/04/10 14:43
 */
public class TryCatchTest {
	public static void main(String[] args) {
		try {
			int i = 1;
			int j = 0;
			i = i / j;
			System.out.println(0);
		} catch (Exception e) {
			System.out.println(1);
			// System.exit(0); // 1
			// throw e; // 1 2
			// 1 2 3
		} finally {
			System.out.println(2);
		}
		System.out.println(3);
	}

}
