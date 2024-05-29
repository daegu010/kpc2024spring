package com.kpc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Step04 {

	public static void main(String[] args) {
		ApplicationContext cntxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		Service03 serv=cntxt.getBean(Service03.class);
		System.out.println(serv);

	}

}
