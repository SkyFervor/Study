package genericType;

public class SuperLimitTest {
	public static void main(String[] args) {
		Generic<? super Child> obj = new Generic<>();
	}
}

class Super {

}

class Child extends Super {

}
