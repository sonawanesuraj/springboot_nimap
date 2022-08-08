package com.demo.controller;

import com.demo.entity.AssignRole;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
	
	@PostMapping("/assignRole")
	public ResponseEntity<?> asignRole(@RequestBody AssignRole asignRole ){
		
		
				
		return null;
		
		
	}
	
	
}
