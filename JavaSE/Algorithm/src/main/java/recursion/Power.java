package recursion;

/**
 * 模拟乘幂方法Math.pow
 */
public class Power {
	/* a^n={a^(n/2)*a^(n/2) (n为偶数)
			a^((n-1)/2)*a^((n-1)/2)*a (n为奇数)} */
	public static double pow(double n, int e) throws Exception {
		if (n == 0 & e < 0)
			throw new Exception("parameter exception");

		if (e == 1)
			return n;
		if (e == 0)
			return 1;
		if (e == -1)
			return (double) 1 / n;

		double tmp = pow(n, e >> 1);
		tmp *= tmp;
		if ((e & 1) == 1)
			tmp *= n;
		else if (e < 0 && ((-e) & 1) == 1)
			tmp *= (double) 1 / n;
		return tmp;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(pow(2, 10));
		System.out.println(pow(3, 9));
		System.out.println(pow(1, 10));
		System.out.println(pow(1, -11));
		System.out.println(pow(2, -10));
		System.out.println(pow(2, -11));
		System.out.println(pow(0, 0));
		System.out.println(pow(0, 10));
		System.out.println(pow(0, -11));
	}
}
