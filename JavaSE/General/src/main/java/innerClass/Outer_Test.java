package innerClass;


public class Outer_Test {

	public static void main(String[] args) {
		// 普通内部类
		// 属于外部类的实例域
		Class<?> inner = new Outer().new Inner().getClass();
		// Class<?> inner = new Inner().getClass(); // Error
		System.out.println(inner);
		System.out.println(inner.getEnclosingClass()); // 获取外部类
		System.out.println(inner.getDeclaringClass()); // 获取申明该类的类

		// 静态内部类
		Class<?> staticInner = new Outer.StaticInner().getClass(); // 通过外部类名调用内部类
		System.out.println("\n" + staticInner);
		System.out.println(staticInner.getEnclosingClass());
		System.out.println(staticInner.getDeclaringClass());

		// 匿名内部类
		// 继承自Outer.StaticInner
		Outer.StaticInner anonStaticInnerObj = new Outer.StaticInner() {
		};
		Class<?> anonStaticInner = anonStaticInnerObj.getClass();
		System.out.println("\n" + anonStaticInner);
		System.out.println(anonStaticInner.getEnclosingClass());
		System.out.println(anonStaticInner.getDeclaringClass()); // 匿名内部类是一种特殊的局部内部类，返回null

		// 局部内部类
		class LocalInner {
			public int get() {
				return 1;
			}
		}
		Class<?> localInner = new LocalInner().getClass();
		System.out.println("\n" + localInner);
		System.out.println(localInner.getEnclosingClass());
		System.out.println(localInner.getDeclaringClass()); // 局部内部类只在方法而未在外部类中声明，返回null

		// 匿名内部类
		// 继承自LocalInner
		int a = 2;
		LocalInner anonInnerObj = new LocalInner() {
			@Override
			public int get() {
				// 访问方法中的局部变量，JDK1.7及之前版本必须是final的，之后可省略final
				// 原因：内部类也是类，其生命周期可能长于局部变量，可能导致访问到已释放的局部变量
				// 原理：内部类中备份局部变量的引用
				return a;
			}

			@SuppressWarnings("unused")
			public int get(int b) {
				return b;
			}
		};
		Class<?> anonInner = anonInnerObj.getClass();
		System.out.println("\n" + anonInner);
		System.out.println(anonInner.getEnclosingClass());
		System.out.println(anonInner.getDeclaringClass()); // 匿名内部类是一种特殊的局部内部类，返回null
		// anonInnerObj是进行了 对象置换 的子类对象，只能调用子类中的 重写方法
		System.out.println(anonInnerObj.get());
		// System.out.println(anonInnerObj.get(1)); // Error

		// 外部类
		Class<?> outer = new Outer().getClass();
		System.out.println("\n" + outer);
		System.out.println(outer.getEnclosingClass()); // 无外部类，返回null
		System.out.println(outer.getDeclaringClass()); // 无所属申明类，返回null
	}

	public static void set(){
		
	}
}
