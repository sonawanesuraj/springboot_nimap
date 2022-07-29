package com.demo.dto;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name","mobileNumber","email"}))
public class UserDto {  
	
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String mobileNumber;
	@Email(message="Email is not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 4,max = 10,message = "password min of 3 chars and max of 10 chars !! ")
	private String password;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
