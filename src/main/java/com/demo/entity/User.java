package com.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.dto.UserDto;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import net.minidev.json.annotate.JsonIgnore;
@Entity
@Table(name="users")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id=?")
@Projection(name ="User",types= {UserDto.class})
public class User  {
	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Value("#{target.id}")
	private int id;
	
	@Column(name = "name")
	@Value("#{target.name}")
	private String name;
	
	@Column(name = "mobileNumber")
	@Value("#{target.mobileNumber}")
	private String mobileNumber; 
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")

	private String password;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
		
	}
	public User() {
		super();
		//TODO Auto-generated constructor stub
	}
	public User(int id, String name, String mobileNumber, String email, String password, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
	
	

}