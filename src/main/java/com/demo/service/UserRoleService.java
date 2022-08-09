package com.demo.service;

import com.demo.dto.UserRoleDto;
import com.demo.entity.RoleEntity;
import com.demo.entity.User;
import com.demo.entity.UserRoleEntity;
import com.demo.entity.UserRoleId;
import com.demo.repository.RoleEntityRepository;
import com.demo.repository.UserRepository;
import com.demo.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
	
	@Autowired
  private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserRoleEntity addRole(UserRoleDto userRoleDto) {
		
		User user = this.userRepository.findByEmail(userRoleDto.getUser());
		System.out.println("User " +user.getId());
		
		RoleEntity roleEntity = this.roleEntityRepository.findByroleName(userRoleDto.getRole());
		System.out.println("============++++===========");
		System.out.println(roleEntity);
		System.out.println("RoleEntity " +roleEntity.getId());
		System.out.println("++++++++++++=============");
		System.out.println(roleEntity.getId());
			
		UserRoleId  userRoleEntity = new UserRoleId(user, roleEntity);
		
		UserRoleEntity pqr = new UserRoleEntity();
		
		pqr.setUri(userRoleEntity);
		
	    userRoleRepository.save(pqr);
		
		return pqr;
		
	}
	
	

	
	

}
