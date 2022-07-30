package com.demo.security;

import com.demo.entity.User;
import com.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a1/auth/")
public class AuthController {
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponce>createToken(@RequestBody JwtAuthRequest request){
		try {
			
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		 String token=this.jwtTokenUtil.generateToken(userDetails);
		
		JwtAuthResponce responce = new JwtAuthResponce();
		responce.setToken(token);
		return new ResponseEntity<JwtAuthResponce>(responce,HttpStatus.OK);
			
		}


	private void authenticate(String username, String password) {
		
		UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username, password);
	
		this.authenticationManager.authenticate(authenticationToken);
	
	}
		
	}
	
	


