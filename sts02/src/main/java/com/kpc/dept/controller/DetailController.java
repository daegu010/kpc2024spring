package com.kpc.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kpc.dept.model.DeptDao;

public class DetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		DeptDao dao=new DeptDao();
		return new ModelAndView("dept/detail","bean",dao.find(deptno));
	}

}
