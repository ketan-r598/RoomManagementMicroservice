package com.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.project.filter.JWTValidationFilter;
import com.project.session.Session;

@Configuration
public class FilterConfig {
	
	public static final String OWNERPATH = "/rooms/owner/*";
	public static final String CUSTOMERPATH = "/rooms/customer/*";
	
	private Session session = Session.getSession();
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		
		if(session.getRole().equalsIgnoreCase("customer")) {
			filterRegistrationBean.addUrlPatterns(CUSTOMERPATH);
		} else if(session.getRole().equalsIgnoreCase("owner")){
			filterRegistrationBean.addUrlPatterns(OWNERPATH);
		} else {
			filterRegistrationBean.addUrlPatterns("");
		}
		
		return filterRegistrationBean;
	}
	
}
