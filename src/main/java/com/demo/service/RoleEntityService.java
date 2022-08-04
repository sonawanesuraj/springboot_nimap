package com.demo.service;

import com.demo.dto.RoleDto;
import com.demo.entity.RoleEntity;
import com.demo.repository.RoleEntityRepository;

import org.springframework.stereotype.Service;

@Service
public class RoleEntityService {
	
	private RoleEntityRepository roleEntityRepository;
	
	 // add role
	
	public RoleEntity addRole(RoleDto roleDto) {
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRoleName(roleDto.getRoleName());
		roleEntity.setDescription(roleDto.getDescription());
		return roleEntityRepository.save(roleEntity);
		
	}

}
