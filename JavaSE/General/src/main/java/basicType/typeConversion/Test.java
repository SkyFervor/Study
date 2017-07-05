package basicType.typeConversion;

/**
 * Created by skyfervor
 * 2017/06/10 14:54
 */
public class Test {

	public static void main(String[] args) {
		char c = '0';
		byte b = 0b0;
		short s = 0;
		int i = 0;
		long l = 0L;
		float f = 0.0f;
		double d = 0.0;

		// s = c; // short有符号，char无符号
		s = b;

		i = c;
		i = b;

		l = i;

		f = i;
		f = l; // 可能丢失精度

		d = i;
		d = l; // 可能丢失精度
		d = f; // 由于补位，同时由于double存储的不精确性，可能造成后面的位数值有 较大误差

		f = 127.1f;
		System.out.println(f);
		d = f;
		System.out.println(d);
	}
}
