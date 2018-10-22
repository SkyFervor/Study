package threadLocal;

public class InheritableThreadLocalTest {

	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) {
		threadLocal.set(123);
		System.out.println("Main threadLocal=" + threadLocal.get());
		new Thread(() -> System.out.println("Child threadLocal=" + threadLocal.get()))
				.start();
	}
}
