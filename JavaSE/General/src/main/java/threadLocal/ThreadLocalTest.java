package threadLocal;

import javafx.util.Pair;

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
		System.out.println(getHashCode());
		threadLocal = null;
		System.out.println(getHashCode());

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

		System.out.println(getHashCode());
	}

	public static List<WeakReference<ThreadLocal>> getThreadLocalMapEntry() {
		try {
			Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
			threadLocalsField.setAccessible(true);
			Object threadLocals = threadLocalsField.get(Thread.currentThread());

			Field tableField = threadLocals.getClass().getDeclaredField("table");
			tableField.setAccessible(true);
			WeakReference<ThreadLocal>[] table = (WeakReference<ThreadLocal>[]) tableField.get(threadLocals);

			List<WeakReference<ThreadLocal>> list = new ArrayList<>();
			for (WeakReference<ThreadLocal> weakReference : table) {
				if (weakReference == null) {
					continue;
				}

				list.add(weakReference);
			}
			return list;
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static List<Pair<Integer, Object>> getHashCode() {
		List<WeakReference<ThreadLocal>> list = getThreadLocalMapEntry();
		System.out.println();
		return getHashCode(list);
	}

	public static List<Pair<Integer, Object>> getHashCode(List<WeakReference<ThreadLocal>> weakReferences) {
		if (weakReferences == null || weakReferences.isEmpty()) {
			return Collections.emptyList();
		}

		List<Pair<Integer, Object>> list = new LinkedList<>();
		try {
			Field hashCodeField = ThreadLocal.class.getDeclaredField("threadLocalHashCode");
			hashCodeField.setAccessible(true);
			Field valueField = weakReferences.get(0).getClass().getDeclaredField("value");
			valueField.setAccessible(true);

			for (WeakReference<ThreadLocal> weakReference : weakReferences) {
				if (weakReference == null) {
					continue;
				}
				Object value = valueField.get(weakReference);
				int hashCode;

				ThreadLocal threadLocal = weakReference.get();
				if (threadLocal == null) {
					if (value == null) {
						continue;
					}
					hashCode = -1;
				} else {
					hashCode = (int) hashCodeField.get(threadLocal);
				}

				list.add(new Pair<>(hashCode, value));
			}
			return list;
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
