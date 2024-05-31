package com.kpc.sts05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpc.sts05.model.Module;

//@Component
public class ModuleService {
	@Autowired
	Module module;
	
	public void serv01() {
		module.func01();
	}
	
	public void serv02() {
		module.func01();
		module.func02("hello");
	}
	
	public void serv03() {
		module.func01();
		module.func02("hello");
		String result=module.func03();
		System.out.println(result);
	}
}
