
public class Test {
	public static void main(String[] args) {
		int x = 0;
		if (x < 2) {
			System.out.println("Small");
		} else if (x < 10) {
			System.out.println("Medium");
		} else {
			System.out.println("LARGE");
		}
		System.out.println("All done");

		//x = 3;
		switch (x) {
		case 0:
			System.out.println("aa");
			x = 4;
			break;
		case 4:
			System.out.println("bb");
			x = 11;
			break;
		case 10:
			System.out.println("cc");
		default:
			System.out.println("end");
		}

	}
}
