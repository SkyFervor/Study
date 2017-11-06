import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.io.IOException;

public class HystrixObservableTest extends HystrixObservableCommand<String> {

	private final String name;

	public HystrixObservableTest(String name) {
		super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
		this.name = name;
	}

	@Override
	protected Observable<String> construct() {
		return Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("Thread: " + Thread.currentThread().getName() + "\t" + name);
				subscriber.onCompleted();
			}
		});
	}

	private static void testObserve() {
		Observable<String> observable = new HystrixObservableTest("observe method").observe();
		observable.subscribe(new Observer<String>() {
			@Override
			public void onCompleted() {
				System.out.println("observable complete");
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("observable error");
			}

			@Override
			public void onNext(String s) {
				System.out.println(s + " (observable onNext)");
			}
		});
	}

	private static void testToObservable() {
		Observable<String> observable = new HystrixObservableTest("toObservable method").toObservable();
		observable.subscribe(new Observer<String>() {
			@Override
			public void onCompleted() {
				System.out.println("toObservable complete");
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("toObservable error");
			}

			@Override
			public void onNext(String s) {
				System.out.println(s + " (toObservable onNext)");
			}
		});
	}

	public static void main(String[] args) throws IOException {
		testObserve();
		testToObservable();
		System.out.println("Main thread: " + Thread.currentThread().getName());
		System.in.read();
	}
}
