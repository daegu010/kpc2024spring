package com.kpc.sts05.model;

import org.springframework.stereotype.Component;

@Component
public class ModuleImpl implements Module {

	@Override
	public void func01() {
		System.out.println("ù��° �����");
	}
	@Override
	public void func02(String msg) {
		System.out.println(msg+"�� �̿��� �ι�° �����");
	}
	@Override
	public String func03() {
		System.out.println("����° ����� �����ϰ� �����ȯ");
		return "���OK";
	}
	@Override
	public void running01() {
		System.out.println("����� ������ ���");
		throw new RuntimeException("�޾ƶ�");
	}
}
