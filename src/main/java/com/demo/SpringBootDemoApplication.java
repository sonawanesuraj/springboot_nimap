package com.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootDemoApplication{


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	
		
	} 
	
	
	@Bean
	public ModelMapper modelMaper() {
		
		return new ModelMapper();
		
	}



}  


