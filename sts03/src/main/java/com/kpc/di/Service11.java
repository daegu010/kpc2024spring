package com.kpc.di;

public class Service11 {

	public void func01() {
		System.out.println("func11 run...");
	}

	public void func02(int a) {
		System.out.println("func12 run..."+a);
	}

	public String func03() {
		System.out.println("func13 run...");
		return "f13";
	}
	
	public void running01(){
		System.out.println("running01...before");
		int su=1;
		if(su==1) throw new RuntimeException("내가 던진 메시지");
		System.out.println("running01...after");
		
	}

	public void running02() {
		System.out.println("running02...");
	}
}
