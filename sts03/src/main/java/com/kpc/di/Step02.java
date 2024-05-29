package com.kpc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Step02 {

	public static void main(String[] args) {
		ApplicationContext ctxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		Service02 serv=(Service02) ctxt.getBean("serv2");
		System.out.println(serv);

	}

}
