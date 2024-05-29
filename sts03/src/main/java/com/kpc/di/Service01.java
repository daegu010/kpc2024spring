package com.kpc.di;

public class Service01 {
	Module module;
	
	public Service01() {
	}
	
	public Service01(Module module) {
		this.module = module;
	}
	
	public void setModule(Module module) {
		this.module = module;
	}
	
	public void running1() {
		module.func01();
	}

	public void running2() {
		module.func01();
	}

}
