package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by shuhaoz
 * 2017/07/10 21:48
 */
public class CallableFutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> callable = () -> {
			Thread.sleep(2000);
			return "end";
		};

		FutureTask<String> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();

		System.out.println(futureTask.get());
	}
}
