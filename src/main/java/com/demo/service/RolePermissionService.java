package com.demo.service;

import java.util.ArrayList;

import com.demo.dto.RolePermissionDto;
import com.demo.entity.PermissionEntity;
import com.demo.entity.RoleEntity;
import com.demo.entity.RolePermissionEntity;
import com.demo.entity.RolePermissionId;
import com.demo.repository.PermissionRepository;
import com.demo.repository.RoleEntityRepository;
import com.demo.repository.RolePermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RolePermissionService {
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired 
	RoleEntityRepository roleEntityRepository;

	
	
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
}


