package com.kpc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Step03 {

	public static void main(String[] args) {
		ApplicationContext ctxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		Service01 serv=(Service01) ctxt.getBean("serv03");
		serv.running1();

	}

}
