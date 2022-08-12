package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.app.dto.EditUserRequestDto;
import com.demo.dto.UserRoleDto;
import com.demo.entity.AssignRole;
import com.demo.entity.UserRoleEntity;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	//  add all role to user 
	
	@PostMapping("/assignRole")
	public ResponseEntity<?> asignRole(@RequestBody UserRoleDto userRoleDto ){
	this.userRoleService.addRolesToUser(userRoleDto);
		
		return ResponseEntity.ok("Role Assign Succefully");
	}
	
	
	// get all user and roles
	
		@GetMapping("/userAndRole")
		public List<UserRoleEntity> getAllUserAndRole(){
			return this.userRoleService.getAllUserRole();
		
			
		}
		
		public ResponseEntity<?> editUserAndRole()
				throws ResourceNotFoundException {
			
					return null;
			
	}

		
	}
	
	
	

