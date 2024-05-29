package com.kpc.aop;

import org.springframework.aop.ThrowsAdvice;

public class KpcAfterErr implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("###############################");
	}
}
