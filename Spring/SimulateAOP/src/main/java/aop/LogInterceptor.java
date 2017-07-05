package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInterceptor implements InvocationHandler {
	private Object target;

	public LogInterceptor(Object target) {
		this.target = target;
	}

	public void beforeMethod(Method method) {
		System.out.println(method.getName() + " start");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeMethod(method);

		method.invoke(target, args);

		return null;
	}
}
