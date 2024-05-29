package com.kpc.aop;

import org.springframework.aop.ThrowsAdvice;

public class KpcAfterErr implements ThrowsAdvice {
// public void afterThrowing(Exception ex)
// public void afterThrowing(RemoteException)
// public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
// public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
	public void afterThrowing(Exception ex) {
		System.out.println("###"+ex.getMessage());
	}
}
