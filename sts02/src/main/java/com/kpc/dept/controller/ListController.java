package com.kpc.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kpc.dept.model.DeptDao;

public class ListController implements Controller {
	DeptDao deptDao;

	public void setDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",deptDao.findAll());
		mv.setViewName("dept/list");
		return mv;
	}

}
