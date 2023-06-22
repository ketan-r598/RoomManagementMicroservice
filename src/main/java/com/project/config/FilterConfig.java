package com.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.project.filter.JWTValidationFilter;
import com.project.session.Session;

@Configuration
public class FilterConfig {
	
	public static final String OWNER_PATH = "/rooms/owner/*";
	public static final String CUSTOMER_PATH = "/rooms/customer/*";
	public static final String ALL_PATH = "/rooms/*";
	
	private Session session = Session.getSession();
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		
		if(session.getRole().equalsIgnoreCase("customer")) {
			filterRegistrationBean.addUrlPatterns(CUSTOMER_PATH);
			System.out.println("\nI am in customer's case \n");
		} else if(session.getRole().equalsIgnoreCase("owner")){
			System.out.println("\nI am in owner's case \n");
			filterRegistrationBean.addUrlPatterns(OWNER_PATH);
		} else {
//			filterRegistrationBean.addUrlPatterns(ALL_PATH);
			System.out.println("\nI am in generic case \n");
		}
		
		return filterRegistrationBean;
	}
	
}
