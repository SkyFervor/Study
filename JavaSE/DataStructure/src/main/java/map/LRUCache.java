package map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap实现LRU缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;

	public LinkedHashMap<K, V> cache = null;
	public int cacheSize = 0;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		int hashTableCapacity = (int) Math.ceil(cacheSize / 0.75f) + 1;
		cache = new LinkedHashMap<K, V>(hashTableCapacity, 0.75f, false) {
			// (an anonymous inner class)
			private static final long serialVersionUID = 1;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				System.out.println("size=" + size());
				return size() > LRUCache.this.cacheSize;
			}
		};
	}

	public V put(K key, V value) {
		return cache.put(key, value);
	}

	public V get(Object key) {
		return cache.get(key);
	}

	@Override
	public String toString() {
		StringBuilder r = new StringBuilder();
		for (Map.Entry<K, V> en : cache.entrySet())
			r.append(en.getKey() + ",");

		return r.toString();
	}

	public static void main(String[] args) {
		LRUCache<String, String> lruCache = new LRUCache<String, String>(5);
		lruCache.put("1", "1");
		lruCache.put("2", "2");
		lruCache.put("3", "3");
		lruCache.put("4", "4");

		System.out.println(lruCache);

		System.out.println(lruCache.get("5"));
		System.out.println(lruCache.get("2"));
		lruCache.put("6", "6");
		System.out.println(lruCache);
		lruCache.put("5", "5");
		System.out.println(lruCache);
		System.out.println(lruCache.get("1"));

	}

}