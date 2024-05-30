package com.kpc.sts04;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// <context-param><param-value>classpath:/applicationContext.xml</param-value>
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// <servlet-class>DispatcherServlet</servlet-class>
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// <servlet-mapping>
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter1=new CharacterEncodingFilter();
		filter1.setEncoding("utf-8");
		HiddenHttpMethodFilter filter2=new HiddenHttpMethodFilter();
		return new Filter[] {filter1,filter2};
	}

}







