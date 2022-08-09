package com.demo.dto;

public class UserRoleDto {
	
	private String user ;
	private String role;
	
	public UserRoleDto() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	public UserRoleDto(String user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
