package com.kpc.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

import com.kpc.di.Service11;

public class KpcBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.print(method.getName());
//		System.out.println(method.getParameterCount());
//		System.out.println(Arrays.toString(args));
//		System.out.println(target);
		System.out.print("--->");
	}

}
