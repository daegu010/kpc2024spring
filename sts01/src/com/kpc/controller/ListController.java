package com.kpc.controller;

import javax.servlet.http.HttpServletRequest;

import com.kpc.framework.KpcController;

public class ListController implements KpcController {

	@Override
	public String execute(HttpServletRequest req) {
		return "list";
	}

}
