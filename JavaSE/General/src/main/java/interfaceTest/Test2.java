package interfaceTest;

/**
 * Created by skyfervor
 * 2017/03/28 20:36
 */
public class Test2 {

}

interface Inter1 {
	default String get() {
		return "Inter1";
	}
}

interface Inter2 {
	default String get() {
		return "Inter2";
	}
}

class Impl implements Inter1, Inter2 {
	// 必须重写，否则报错
	@Override
	public String get() {
		return "Class";
	}
}