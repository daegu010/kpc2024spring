package com.kpc.sts05;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kpc.sts05.model.DeptVo;
import com.kpc.sts05.service.DeptService;

@Controller
public class HomeController {
	@Autowired
	DeptService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("/dept/")
	public @ResponseBody List<DeptVo> list() {
		return service.getList();
	}
	
	@PostMapping("/dept/")
	public ResponseEntity<?> add(DeptVo bean) {
		if(bean==null) return ResponseEntity.badRequest().build();
		service.addDb(bean);
		return ResponseEntity.ok().build();
	}
	
}
















