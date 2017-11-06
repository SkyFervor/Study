import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HystrixCommandTest extends HystrixCommand<String> {

    private final String name;

    public HystrixCommandTest(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Thread: " + Thread.currentThread().getName() + "\t" + name;
    }

    private static void testExecute() {
        String result = new HystrixCommandTest("execute method").execute();
        System.out.println(result);
    }

    private static void testQueue() throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> future = new HystrixCommandTest("queue method").queue();
        String result = future.get(100, TimeUnit.SECONDS);
        System.out.println(result);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        testExecute();
        testQueue();
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
