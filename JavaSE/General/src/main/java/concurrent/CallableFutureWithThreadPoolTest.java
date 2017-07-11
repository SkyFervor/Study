package concurrent;

import java.util.concurrent.*;

/**
 * Created by shuhaoz
 * 2017/07/10 21:53
 */
public class CallableFutureWithThreadPoolTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		test1();
		test2();
	}

	public static void test1() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		Callable<String> callable1 = () -> {
			Thread.sleep(1000);
			return "end1";
		};
		Callable<String> callable2 = () -> {
			Thread.sleep(2000);
			return "end2";
		};
		for (int i = 0; i < 5; i++) {
			completionService.submit(callable1);
			completionService.submit(callable2);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(completionService.take().get());
		}
		System.out.println("final");
	}

	public static void test2() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "end1";
		};
		/* Direct submit */
		System.out.println();
		Future<String> future = executorService.submit(callable);
		System.out.println(future.get());
	}
}
