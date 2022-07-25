package com.demo.repository;

import com.demo.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Optional<User> findByIdAndIsActiveTrue(Long id);
	
	Page<User>findByOrderById(Pageable pageable , Class<User> user);
	Page<User>findByName(String name,Pageable pageable ,Class<User> user);
	
}
