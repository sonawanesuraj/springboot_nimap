package com.demo.ServiceImpl;

import com.demo.entity.User;
import com.demo.service.AuthInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthServiceImpl implements AuthInterface{

	@Autowired
	private User  user;
	
	
	@Override
	public UserDetails loadUserByUserName(String email) throws UsernameNotFoundException {
      
		if(user == null) {
			
			throw new UsernameNotFoundException("User not found with Email: " + email);

		}
		
		
		
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean comaprePassword(String Password, String hashPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
