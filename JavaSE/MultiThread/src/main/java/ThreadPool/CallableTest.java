package ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 第三种创建线程的方法
 * <p>
 * 使用{@link java.util.concurrent.Callable}接口配合线程池实现带有返回值的线程
 * 
 * @author SkyFervor
 *
 */
public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable task1 = new MyCallable(0);
		MyCallable task2 = new MyCallable(1);
		MyCallable task3 = new MyCallable(2);

		ExecutorService es = Executors.newFixedThreadPool(3);

		Future<String> future1 = es.submit(task1);
		System.out.println("task1:" + future1.get());

		Future<String> future2 = es.submit(task2);
		Thread.sleep(1000);
		System.out.println("task2 cancle:" + future2.cancel(true));

		Future<String> future3 = es.submit(task3);
		System.out.println("task3:" + future3.get());
	}
}

class MyCallable implements Callable<String> {
	private int flag;

	public MyCallable(int flag) {
		this.flag = flag;
	}

	@Override
	public String call() throws Exception {
		if (flag == 0)
			return "flag=0";
		else if (flag == 1) {
			try {
				while (true) {
					System.out.println("looping...");
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
			return "false";
		} else
			throw new Exception("bad flag value");
	}
}