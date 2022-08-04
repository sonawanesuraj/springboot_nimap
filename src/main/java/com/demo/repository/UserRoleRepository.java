package com.demo.repository;

import com.demo.entity.UserRoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer>{

}
