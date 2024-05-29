package com.kpc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// IoC
// DI
public class Step01 {

	public static void main(String[] args) {
		ApplicationContext context
				=new ClassPathXmlApplicationContext("/applicationContext.xml");
		Service01 serv=(Service01) context.getBean("service");
		serv.running1();
	}

}
