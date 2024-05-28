package com.kpc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("msg", "환영합니다");
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "두번째 페이지입니다.");
		mav.setViewName("intro");
		return mav;
	}

}
