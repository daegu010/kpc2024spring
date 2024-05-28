package com.kpc.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.kpc.dept.model.DeptDao;

public class AddController extends SimpleFormController {
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request
				, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		System.out.println(command);
		System.out.println(errors);
		
		mav.setViewName("redirect:/dept/list.kpc");
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav=new ModelAndView();
//		if("GET".equals(request.getMethod())) {
//			mav.setViewName("redirect:add.kpc");
//			return mav;
//		}
//		request.setCharacterEncoding("utf-8");
//		String dname=request.getParameter("dname");
//		String loc=request.getParameter("loc");
//		DeptDao dao=new DeptDao();
//		dao.save(dname,loc);
//		mav.setViewName("redirect:/dept/list.kpc");
//		return mav;
//	}

}
