package threadLocal;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuhaoz
 * 2017/07/06 15:15
 */
public class ThreadLocalTest {

	public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("test");
		System.out.println(getHashCode(Collections.singletonList(threadLocal)));
		System.out.println(getThreadLocalsHashCode());
		threadLocal = null;
		System.out.println(getThreadLocalsHashCode());

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(new ArrayList<Integer>(){
				{
					for (int i = 0; i < 10000; i++) {
						add(i);
					}
				}
			});
		}
		list = null;
		System.gc();
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(ThreadLocalTest.getThreadLocalsHashCode());
	}

	public static List<Integer> getThreadLocalsHashCode() {
		try {
			Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
			threadLocalsField.setAccessible(true);
			Object threadLocals = threadLocalsField.get(Thread.currentThread());

			Field tableField = threadLocals.getClass().getDeclaredField("table");
			tableField.setAccessible(true);
			WeakReference<ThreadLocal>[] table = (WeakReference<ThreadLocal>[]) tableField.get(threadLocals);

			List<ThreadLocal> list = new ArrayList<>();
			for (WeakReference<ThreadLocal> weakReference : table) {
				if (weakReference == null) {
					continue;
				}

				list.add(weakReference.get());
			}
			return getHashCode(list);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static List<Integer> getHashCode(List<ThreadLocal> threadLocals) {
		List<Integer> list = new LinkedList<>();
		try {
			Field field = ThreadLocal.class.getDeclaredField("threadLocalHashCode");
			field.setAccessible(true);
			for (ThreadLocal threadLocal : threadLocals) {
				if (threadLocal == null) {
					continue;
				}
				int hashCode = (int) field.get(threadLocal);
				list.add(hashCode);
			}
			return list;
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
