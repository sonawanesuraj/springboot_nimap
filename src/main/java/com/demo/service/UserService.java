package com.demo.service;

import java.util.Optional;

import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.utility.Pagination;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	
	
	// add user 
	public User insertUser(User user){
		return userRepository.save(user);
	}
	
	// // update  users by id
	public User addUser(User user){
		return userRepository.save(user);
		
	}
	// get all user (Get)
	//public List<User> getAllUsers(){
	//	return userRepository.findAll();
	//} 
	
	
	public Page<User> getAllUsers(String search,String pageNo,String pageSize){
		
		Pageable pageable = new Pagination().getPegination(pageNo, pageSize);
		
		if((search=="")||(search==null)||(search.length()==0)) {
			
			return userRepository.findByOrderById(pageable, User.class );
		}
		else
			
		return userRepository.findByName(search, pageable, User.class);
		
	}
	

	// get user by id 
	
	public User getByUserId(Integer id) throws ResourceNotFoundException{
		User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("RESOURCE NOT FOUND"));
		return user;
	}
	
	// delete all user
	public void deleteAllUser(User user) {
		userRepository.deleteAll();
		
	}
	
	
	// delete user by id
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}

	
}
