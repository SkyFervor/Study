package interfaceTest;

/**
 * Created by SkyFervor on 2017/7/11 00011.
 */
public class DefaultMethodTest {
	interface Interface1 {
		default String get() {
			return "Interface1";
		}
	}

	interface Interface2 {
		default String get() {
			return "Interface2";
		}
	}

	static abstract class AbstractClass implements Interface1, Interface2 {
		// 由于两个接口有同签名的默认方法，必须在类中实现
		@Override
		public String get() {
			return null;
		}
	}

}
