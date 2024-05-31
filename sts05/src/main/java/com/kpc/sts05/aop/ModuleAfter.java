package com.kpc.sts05.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect		//<aop:aspect ref="beforeAdvice">
//@Component	//<bean id="beforeAdvice"
public class ModuleAfter {

	//<aop:after-returning returning="msg" ~ pointcut-ref="m1"/>
//	@AfterReturning(returning = "msg",pointcut = "execution(* com.kpc.sts05.model.Module.*(..))")
	public void afterReturn(JoinPoint join,String msg) {
		System.out.println(">>>"+msg);
	}
	
	//<aop:after-throwing throwing="e" ~ pointcut-ref="m1"/>
//	@AfterThrowing(throwing = "e",pointcut = "execution(* com.kpc.sts05.model.Module.*(..))")
	public void afterErr(Exception e) {
		System.out.println(e.getMessage());
	}
}
















