package tryCatchFinally;

/**
 * 观察finally对方法调用的影响
 */
public class Test {

	public static void main(String[] args) {

		System.out.println("i的值为：" + test());

	}

	private static int test() {

		int i = 0;

		try {

			return i;

		} catch (RuntimeException e) {
			throw e; // 语法上是可以捕获和抛出RuntimeException的
		} finally {

			++i;

			System.out.println("finally is Executed…");

		}

	}
}
