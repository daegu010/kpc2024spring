package com.kpc.sts05.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class ModuleAround {

//	@Around("execution(* com.kpc.sts05.model.Module.*01(..))")
	public Object around(ProceedingJoinPoint join) {
		System.out.println("around before..");
		Object obj=null;
		try {
			obj=join.proceed();
			System.out.println("around after return..");
		} catch (Throwable e) {
			System.out.println("around after err..");
		}
		return obj;
	}
}
