
package com.demo.security;

import java.util.Calendar;

import com.demo.ServiceImpl.AuthServiceImpl;
import com.demo.dto.LoggerDto;
import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ErrorDetails;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.service.LoggerServiceInterface;
import com.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@Autowired
	private AuthServiceImpl authServiceImpl;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	JwtAuthResponce jwtAuthResponce;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;
	
@Autowired
private UserDetailsService userDetailsService;


	@Autowired
	LoggerServiceInterface loggerServiceInterface;

	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest authenticationResuest)
			throws Exception, ResourceNotFoundException {
		try {
			User user = userRepository.findByEmail(authenticationResuest.getEmail());
			System.out.println("a"+user);
			if (authServiceImpl.comaprePassword(authenticationResuest.getPassword(),user.getPassword())) {

			System.out.println("Data" + user.getEmail());
	        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationResuest.getEmail());

			final String token = jwtTokenUtil.generateToken(userDetails);
			LoggerDto loggerDto = new LoggerDto();
			loggerDto.setToken(token);
			Calendar calender = Calendar.getInstance();
			calender.add(Calendar.MINUTE, 20);
			loggerDto.setExpireAt(calender.getTime());
			loggerServiceInterface.createLogger(loggerDto, user);
			
			return new ResponseEntity<>(new JwtAuthResponce(token),HttpStatus.CREATED);

		 
			}
		}catch (ResourceNotFoundException e) {
				System.out.println("Error___!!!!!!!!!!");
				//return new ResponseEntity(new ErrorResponceDto("NOT FOUND", "try again"),HttpStatus.BAD_REQUEST);
			}
		
			
	return ResponseEntity.ok("invalid username or password");
	}

	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

		return ResponseEntity.ok(this.userService.save(userDto));

	}

}
