package com.kpc.sts04.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kpc.sts04.model.DeptDao;
import com.kpc.sts04.model.DeptVo;

@Controller
public class DeptController {
	@Autowired
	DeptDao<DeptVo> deptDao;

	@RequestMapping("/dept/")
	public String list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
		return "dept/list";
	}
	
	// url - restful
	@RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
	public String list(Model model,@PathVariable("deptno") int deptno) {
		model.addAttribute("bean", deptDao.select(deptno));
		return "dept/detail";
	}
	
	@GetMapping("/dept/add")
	public void addform() {}

	@PostMapping("/dept/add")
	public String insert(String dname,String loc) {
		deptDao.insertOne(new DeptVo(0, dname, loc));
		return "redirect:./";
	}
	@PutMapping(value = "/dept/{deptno}")
	public String edit(int deptno,String dname,String loc) {
		System.out.println(deptno+dname);
		deptDao.updateOne(new DeptVo(deptno,dname,loc));
		return "redirect:./";
	}
	@DeleteMapping(value = "/dept/{deptno}")
	public String delete(int deptno) {
		System.out.println(deptno);
		deptDao.deleteOne(deptno);
		return "redirect:./";
	}
}
















