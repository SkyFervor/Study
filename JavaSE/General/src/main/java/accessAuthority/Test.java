package accessAuthority;

public class Test {
	private static int x = 100;// 2

	public static void main(String args[]) {// 3
		Test t1 = new Test();// 4
		t1.x++;// 5
		Test t2 = new Test();// 6
		t2.x++;// 7
		t1 = new Test();// 8
		t1.x++;// 9
		Test.x--;// 10
		System.out.println(" x=" + x);// 11
	}
}
