package com.kpc.controller;

import javax.servlet.http.HttpServletRequest;

import com.kpc.framework.KpcController;

public class IndexController implements KpcController{

	public String execute(HttpServletRequest req) {
		return "index";
	}
}
