package question;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Test {
	public static long startTime = System.currentTimeMillis();
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
			0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

	public static void main(String[] args) {
		long start = 1L;
		long end = 9999999999L;
		long batchSize = 50000;

		Queue<Pair<Long, Long>> queue = new ConcurrentLinkedQueue<>();
		long batchStart = start;
		while (batchStart < end) {
			queue.add(new Pair<>(batchStart, batchStart + batchSize - 1));

			batchStart += batchSize;
		}

		while (!queue.isEmpty()) {
			List<TestWorker> list = new ArrayList<>();
			for (int i = 0; i < executor.getMaximumPoolSize(); i++) {
				TestWorker worker = new TestWorker(queue);
				list.add(worker);
			}
			try {
				List<Future<List<Long>>> futureList = executor.invokeAll(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Total cost is %d millisecond\n", System.currentTimeMillis() - startTime);
	}
}

class TestWorker implements Callable<List<Long>> {

	private Queue<Pair<Long, Long>> queue;

	public TestWorker(Queue<Pair<Long, Long>> queue) {
		this.queue = queue;
	}

	@Override
	public List<Long> call() throws Exception {
		Pair<Long, Long> pair;
		while ((pair = queue.poll()) != null) {
			TestResolver resolver = new TestResolver(pair);
			resolver.resolve();
		}
		return null;
	}

}

class TestResolver {
	private int length = 1;
	private long[] num = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	private long start;
	private long end;

	public TestResolver(Pair<Long, Long> pair) {
		this.start = pair.getKey();
		this.end = pair.getValue();
	}

	public List<Long> resolve() {
		List<Long> result = new ArrayList<>();
		for (Long i = start; i < end; i++) {
			int length = i.toString().length();
			if (length != this.length) {
				while (this.length < length) {
					for (int k = 0; k < num.length; k++) {
						num[k] *= k;
					}
					this.length++;
				}
			}

			if (is(i)) {
				result.add(i);
				System.out.printf("%d, total cost is %d millisecond now\n", i, System.currentTimeMillis() - Test.startTime);
			}
		}
		return result;
	}

	private boolean is(long l) {
		long sum = 0;
		long newLong = l;
		while (newLong > 0) {
			sum += num[(int) (newLong % 10)];
			newLong /= 10;
		}
		return sum == l;
	}
}