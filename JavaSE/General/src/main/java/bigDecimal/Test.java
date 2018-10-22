package bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		BigDecimal num = new BigDecimal(1100);
		BigDecimal result = num.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
		System.out.println(result.toString());
	}

	public static void test2() {
		DecimalFormat format = new DecimalFormat("0.0#");
		BigDecimal num = new BigDecimal("1100").divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
		String result = format.format(num);
		System.out.println(num);
		System.out.println(result);
	}
}
