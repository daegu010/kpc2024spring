package com.kpc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kpc.model.DeptDao;

public class DetailController implements Controller {
	DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		return new ModelAndView("dept/detail","bean",deptDao.selectOne(deptno));
	}

}
