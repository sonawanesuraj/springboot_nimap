package com.demo.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer{
	
	public WebMvcConfig() {
		
	}
	
	@Autowired
	ApiLogger apiLogger;

}
