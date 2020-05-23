package com.mobile.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {HibernateConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return  null;
	}

	@Override
	protected String[] getServletMappings() {
		return new  String[] {"/"};
	}
}