package com.demo.security;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class JwtAuthResponce implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String jwttoken;

	public String getJwttoken() {
		return jwttoken;
	}

	public JwtAuthResponce(String   jwttoken) {
		
		 this.jwttoken=jwttoken;
	}

	public JwtAuthResponce() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}