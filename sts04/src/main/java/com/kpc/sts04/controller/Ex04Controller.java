package com.kpc.sts04.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public String ex04(HttpServletRequest req) {
		String id=req.getParameter("id");
		System.out.println(id);
		return "ex04";
	}
	@RequestMapping("/ex05")
	public void ex05(HttpServletResponse res) throws IOException {
		res.sendRedirect("http://google.com");
	}

	@RequestMapping("/ex06")
	public String ex06(HttpSession session) throws IOException {
		System.out.println(session.getId());
		return "ex04";
	}
}















