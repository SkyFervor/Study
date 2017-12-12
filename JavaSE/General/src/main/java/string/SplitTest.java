package string;

import java.util.Arrays;

public class SplitTest {
	public static void main(String[] args) {
		String s = "123";

		System.out.println(Arrays.toString(s.split("")));
		System.out.println(Arrays.toString(s.split("\r\n")));
		System.out.println(Arrays.toString(s.split("3")));
		System.out.println(Arrays.toString(s.split(",")));
	}
}
