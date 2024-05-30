package com.kpc.sts04.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex06Controller {

	@RequestMapping("/ex25")
	public String ex25(HttpServletRequest req) {
		req.setAttribute("msg", "ex25 page");
		return "ex05";
	}

	@RequestMapping("/ex26")
	public ModelAndView ex26() {
		return new ModelAndView("ex05","msg","ex26 page");
	}
	
	@RequestMapping("/ex27")
	public String ex27(Model model) {
		model.addAttribute("msg", "ex27 page");
		return "ex05";
	}
	
	@RequestMapping("/ex28")
	public String ex28(Model model,String msg) {
		model.addAttribute("msg", msg);
		return "ex05";
	}
	
	@RequestMapping("/ex29")
	public String ex29(@ModelAttribute("msg")String msg) {
		return "ex05";
	}
	
//	@RequestMapping("/ex30")
//	public String ex30(@ModelAttribute Map map) {
//		System.out.println(map);
//		return "ex05";
//	}
	
	@RequestMapping("/dept/ex30")
	public void aaaa() {}//  dept/ex30.jsp
}














