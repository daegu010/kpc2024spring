package com.kpc.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet{
	Map<String,KpcController> map=new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		KpcController controller=null;
		Properties props=new Properties();
		try {
			props.load(new FileInputStream("C:\\workspace\\spring\\sts01\\src\\kpc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<String> en = (Enumeration<String>) props.propertyNames();
		try {
			while(en.hasMoreElements()) {
				String url=en.nextElement();
				String info=props.getProperty(url);
					controller=(KpcController)(Class.forName(info).newInstance());
				map.put(url, controller);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getRequestURI().substring(req.getContextPath().length());
		KpcController controller = map.get(url);
		String view=controller.execute(req);
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		view=prefix+view+suffix;
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}







