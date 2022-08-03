package com.demo.interceptors;

import com.demo.service.ApiLoggerServiceInterface;
import com.demo.service.LoggerServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class ApiLogger implements HandlerInterceptor{
	
	@Autowired
	private LoggerServiceInterface  loggerServiceInterface;
	
	@Autowired
	ApiLoggerServiceInterface apiLoggerServiceInterface;
	

}
