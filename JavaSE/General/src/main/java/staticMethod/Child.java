package staticMethod;

public class Child extends Super {
	public static int get() {
		return 1;
	}

	public static void main(String[] args) {
		Super s_c = new Child();
		System.out.println(s_c.get());
	}
}
