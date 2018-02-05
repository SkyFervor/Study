package genericType;

public class GenericOverrideTest {

	interface X {
		Iterable m(Iterable<String> args);
	}

	interface Y {
		Iterable<String> m(Iterable args);
	}

	interface Z extends X, Y {
	}

	class C implements Z {
		@Override
		public Iterable<String> m(Iterable args) {
			return null;
		}
	}
}
