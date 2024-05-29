package com.kpc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class KpcRound implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj= null;
		System.out.print("before<<<<<");
		try {
			obj=invocation.proceed();
		System.out.println("<<<<<after returnning");
		}catch (Exception e) {
			System.out.println("<<<<<after throw err");
			throw e;
		}
//		System.out.println("return :"+obj);
		return "대체";
	}

}
