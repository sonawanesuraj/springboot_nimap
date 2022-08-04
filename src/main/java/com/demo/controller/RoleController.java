package com.demo.controller;

import com.demo.dto.RoleDto;
import com.demo.service.RoleEntityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/")
public class RoleController {
	
	private RoleEntityService roleEntityService;
	
	@PostMapping("/role")
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto){
	this.roleEntityService.addRole(roleDto);
		return new ResponseEntity<>(roleDto,HttpStatus.CREATED);
	}
	

	
	
}
