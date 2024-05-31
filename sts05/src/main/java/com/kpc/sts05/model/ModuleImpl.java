package com.kpc.sts05.model;

import org.springframework.stereotype.Component;

@Component
public class ModuleImpl implements Module {

	@Override
	public void func01() {
		System.out.println("첫번째 모듈기능");
	}
	@Override
	public void func02(String msg) {
		System.out.println(msg+"를 이용한 두번째 모듈기능");
	}
	@Override
	public String func03() {
		System.out.println("세번째 모듈을 실행하고 결과변환");
		return "모듈OK";
	}
	@Override
	public void running01() {
		System.out.println("모듈의 별도의 기능");
		throw new RuntimeException("받아라");
	}
}
