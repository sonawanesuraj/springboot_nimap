package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.demo.dto.UserRoleDto;
import com.demo.entity.RoleEntity;
import com.demo.entity.User;
import com.demo.entity.UserRoleEntity;
import com.demo.entity.UserRoleId;
import com.demo.repository.RoleEntityRepository;
import com.demo.repository.UserRepository;
import com.demo.repository.UserRoleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserRoleService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
  private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// add  all role to user
		public void addRolesToUser(UserRoleDto userRoleDto) {
			ArrayList<UserRoleEntity> roles = new ArrayList<>();	
			User user = this.userRepository.findByEmail(userRoleDto.getEmail());
			System.out.println("User " +user.getId());		
			RoleEntity roleEntity = this.roleEntityRepository.findByName(userRoleDto.getRole());	
			System.out.println("RoleEntity " +roleEntity.getId());			
			UserRoleId  userRoleEntity = new UserRoleId(user, roleEntity);		
			UserRoleEntity pqr = new UserRoleEntity();		
			pqr.setUri(userRoleEntity);
			roles.add(pqr);
			userRoleRepository.saveAll(roles);		
			
		}
	
	// get all User and Role
	
	public List<UserRoleEntity> getAllUserRole(){
		List<UserRoleEntity> list = this.userRoleRepository.findAll();
		return list;
	}
	
	
	
	
	

	
	

}
