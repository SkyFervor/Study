package ThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by skyfervor
 * 2017/05/25 11:15
 */
public class ExecutorTest {
	static void doit() throws Exception {
		final int count = 200;
		final AtomicInteger checkNum = new AtomicInteger(0);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(100);

		final Map<Long, String> map = new HashMap<>();
		map.put(0L, "test");
		for (int j = 0; j < count; j++) {
			newFixedThreadPool.submit(() -> {
				long rand = System.nanoTime() + new Random().nextLong();
				map.put(rand, "test");
				String obj = map.get(0L);
				if (obj == null) {
					checkNum.incrementAndGet();
				}
			});
		}
		newFixedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
		newFixedThreadPool.shutdown();

		System.out.println("checkNum:" + checkNum);
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			doit();
			Thread.sleep(500L);
		}
	}
}
