package genericType;

public class Generic<T> {

	void set(T t) {
		System.out.println("Generic.set");
		System.out.println(t.getClass().getSimpleName());
	}

	T get() {
		return null;
	}
}
