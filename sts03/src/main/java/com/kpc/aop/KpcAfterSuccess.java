package com.kpc.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class KpcAfterSuccess implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object rv, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(rv);
	}

}
