package com.demo.repository;

import javax.transaction.Transactional;

import com.demo.entity.RolePermissionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolePermissionRepository  extends JpaRepository<RolePermissionEntity, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE role permission p SET role_role_id=:role_role_id WHERE p.permission_id=:permission_id",nativeQuery = true)
	void updateUserRole(@Param("role_role_id") int role_id,@Param("user_id") int permission_id);

	
}
