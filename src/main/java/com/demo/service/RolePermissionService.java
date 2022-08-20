package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.dto.RolePermissionDto;
import com.demo.entity.AssignPermission;
import com.demo.entity.PermissionEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.RolePermissionEntity;
import com.demo.entity.RolePermissionId;
import com.demo.repository.PermissionRepository;
import com.demo.repository.RoleEntityRepository;
import com.demo.repository.RolePermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired 
	RoleEntityRepository roleEntityRepository;

	// add permission to role 
	
  public void addPermissionToRole(RolePermissionDto dto) {
	  ArrayList<RolePermissionEntity> permission = new ArrayList<>();
	  RoleEntity roleEntity=this.roleEntityRepository.findById(dto.getRoleId()).get();
      PermissionEntity permissionEntity =  permissionRepository.findById(dto.getPermissionId()).get();
	  RolePermissionEntity permissionEntity1=new RolePermissionEntity();
	  RolePermissionId rolePermissionId = new RolePermissionId(roleEntity, permissionEntity);
	  
	  permissionEntity1.setPk(rolePermissionId);
	  
	  permission.add(permissionEntity1);
	  
	  rolePermissionRepository.saveAll(permission);
  }
  
  // get all role permissions
  public List<RolePermissionEntity> getAllRolePermission(){
	  List<RolePermissionEntity> list = rolePermissionRepository.findAll();
	return list;
	  
  }


public void updatePermission(AssignPermission rolePermissionDto) {
	RolePermissionId  rolePermissionId = new RolePermissionId();
	RoleEntity roleEntity = this.roleEntityRepository.findById(rolePermissionDto.getRoleId()).orElseThrow();
	PermissionEntity permissionEntity = this.permissionRepository.findById(rolePermissionDto.getPermissionId()).orElseThrow();
	rolePermissionId.setRole(roleEntity);
	rolePermissionId.setPermission(permissionEntity);
	
	RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
	rolePermissionEntity.setPk(rolePermissionId);
	this.rolePermissionRepository.updatePermission(roleEntity.getId(),permissionEntity.getId());
	
}
}	




