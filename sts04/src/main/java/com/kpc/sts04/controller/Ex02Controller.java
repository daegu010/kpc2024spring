package com.kpc.sts04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex02Controller{

	@RequestMapping("/ex02")
	public ModelAndView ex02page(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("ex02");
	}
	

	@RequestMapping("/ex03")
	public ModelAndView ex03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("ex03");
	}

}
