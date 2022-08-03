package com.demo.service;

import com.demo.dto.LoggerDto;
import com.demo.entity.User;

public interface LoggerServiceInterface {
	
	void createLogger(LoggerDto loggerDto,User user);
	
	void logout(String token);
	

}
