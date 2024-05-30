package com.kpc.sts04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex05Controller {

	@RequestMapping("/ex15")
	public String ex15(@RequestParam("id")String id2
						,@RequestParam("pw")int pw2) {
		System.out.println(id2);
		System.out.println(pw2+1);
		return "ex05";
	}

	@RequestMapping("/ex16")
	public String ex16(@RequestParam String id
						,@RequestParam int pw) {
		System.out.println(id);
		System.out.println(pw+1);
		return "ex05";
	}

	@RequestMapping("/ex17")
	public String ex17(String id,int pw) {
		System.out.println(id);
		System.out.println(pw+1);
		return "ex05";
	}
}
















