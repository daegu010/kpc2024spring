package com.kpc.sts05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect		//<aop:aspect ref="beforeAdvice">
//@Component	//<bean id="beforeAdvice"
public class ModuleBefore{

	//<aop:before ~~~ pointcut-ref="m1"/>
//	@Before("execution(* com.kpc.sts05.model.Module.*01(..))")
	public void before2(JoinPoint join) {
//		System.out.println(join.getSignature().getName());
//		System.out.println(Arrays.toString(join.getArgs()));
//		System.out.println(join.getTarget());
		System.out.println("<<<");
	}


}
	