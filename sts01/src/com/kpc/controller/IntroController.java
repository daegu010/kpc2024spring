package com.kpc.controller;

import javax.servlet.http.HttpServletRequest;

import com.kpc.framework.KpcController;

public class IntroController implements KpcController{

	public String execute(HttpServletRequest req) {
		req.setAttribute("msg", "abcdefg");
		return "intro";
	}
}
