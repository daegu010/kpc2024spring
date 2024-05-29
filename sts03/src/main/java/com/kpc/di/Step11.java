package com.kpc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Step11 {

	public static void main(String[] args) {
		ApplicationContext cntxt=new ClassPathXmlApplicationContext("applicationContext3.xml");
		Service11 serv=(Service11) cntxt.getBean("serv11");
		serv.func01();
		serv.func02(1234);
		System.out.println(serv.func03());
		serv.running01();
	}

}
