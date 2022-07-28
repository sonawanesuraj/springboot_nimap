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
	public UserDto createUser(UserDto userDto){
		User user = this.dtoToUser(userDto);
		User user1=this.userRepository.save(user);
		return this.userToDto(user1);
		
	  
	}
	     // update user by id
	
	public UserDto updateUser(UserDto userDto,Integer id){
		User user=this.userRepository.findById(id).orElseThrow();
		
		user.setName(userDto.getName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		UserDto saveUser=this.userToDto(user);
		return saveUser;
		
		
		
	}
	
	
	// get all users
	
	public Page<User> getAllUsers(String search,String pageNo,String pageSize){
		
		Pageable pageable = new Pagination().getPegination(pageNo, pageSize);
		
		if((search=="")||(search==null)||(search.length()==0)) {
			
			return userRepository.findByOrderById(pageable, User.class );
		}
		else
			
		return userRepository.findByNameIgnoreCaseContaining(search, pageable, User.class);
		
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

	
	//User To Dto
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		
	return	userDto;
		
		
	}
	
	//Dto to User
	
	public User dtoToUser(UserDto userDto) {
	User user=this.modelMapper.map(userDto,User.class);
		return user;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
