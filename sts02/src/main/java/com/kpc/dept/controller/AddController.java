package com.kpc.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.kpc.dept.model.DeptDao;
import com.kpc.dept.model.DeptVo;

public class AddController extends SimpleFormController {
	DeptDao deptDao;

	public void setDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request
				, Object command, BindException errors)
			throws Exception {
		DeptVo bean=(DeptVo) command;
		if(bean.getDname().isEmpty()) {
			ObjectError error=new ObjectError("dname", "빈값허용하지 않음");
			errors.addError(error);
		}
	}
	
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request
				, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		ModelAndView mav=new ModelAndView();
		if(errors.hasErrors()) {
			mav.setViewName("redirect:add.kpc");
			return mav;
		}
		DeptVo bean=(DeptVo) command;
		deptDao.save(bean.getDname(), bean.getLoc());
		
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
