package com.kpc.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kpc.dept.model.DeptDao;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeptDao dao=new DeptDao();
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",dao.findAll());
		mv.setViewName("dept/list");
		return mv;
	}

}
