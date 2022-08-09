package com.demo.controller;

import com.demo.dto.UserRoleDto;
import com.demo.entity.AssignRole;
import com.demo.entity.UserRoleEntity;
import com.demo.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@PostMapping("/assignRole")
	public ResponseEntity<?> asignRole(@RequestBody UserRoleDto userRoleDto ){
		
		UserRoleEntity role = this.userRoleService.addRole(userRoleDto);
		
		return new ResponseEntity<>(role,HttpStatus.CREATED);
		
		
	}
	
	
}
