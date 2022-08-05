package com.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import com.demo.dto.RoleDto;
import com.demo.entity.RoleEntity;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.RoleEntityRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleEntityService {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private RoleEntityRepository roleEntityRepository;

	// add role

	public RoleEntity addRole(RoleDto roleDto) {

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRoleName(roleDto.getRoleName());
		roleEntity.setDescription(roleDto.getDescription());
		return roleEntityRepository.save(roleEntity);

	}
	
	// get all roles

	
	public List<RoleDto> getAllRoles() {
		List<RoleEntity> roles=this.roleEntityRepository.findAll();
		List<RoleDto> saveRoles=roles.stream().map(e -> this.modelMapper.map(e, RoleDto.class)).collect(Collectors.toList());
		return saveRoles;
	}

	// get role by id 
	public RoleDto getByRoleId(Integer id) {
		RoleEntity roleEntity= this.roleEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Role Id Not Found "+id));
		return this.modelMapper.map(roleEntity, RoleDto.class);
		 
	}
	
	// update role by id 
	
	public void updateRole(RoleDto roleDto ,Integer id) {
		RoleEntity role = this.roleEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Role Not Found "+id));
		role.setRoleName(role.getRoleName());
		roleEntityRepository.save(role);
		
	}
	
	// delete role by id
	
	public RoleDto deleteRole(Integer id) {
		RoleEntity entity=this.roleEntityRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("not found id"+id));
		this.roleEntityRepository.delete(entity);
		return  this.modelMapper.map(entity, RoleDto.class);
		
	}
}

	
	
	
	
	
	


