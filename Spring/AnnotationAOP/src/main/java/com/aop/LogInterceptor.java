package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	@Before("execution(public * com.service..*.add(..))")
	public void before() {
		System.out.println("method before");
	}

	@Pointcut("execution(public * com.dao..*(..))")
	public void myMethod() {
	};

	@AfterReturning("myMethod()")
	public void afterReturning() {
		System.out.println("method after returning");
	}

	@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("method around start");
		pjp.proceed();
		System.out.println("method around end");

	}
}
