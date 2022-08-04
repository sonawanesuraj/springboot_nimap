package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
@Embeddable
public class UserRoleId implements Serializable {
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private RoleEntity role;

	public UserRoleId(User user, RoleEntity role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UserRoleId() {
		super();
		//TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
	
	

}
