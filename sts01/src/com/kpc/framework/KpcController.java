package com.kpc.framework;

import javax.servlet.http.HttpServletRequest;

public interface KpcController {
	String execute(HttpServletRequest req);
}
