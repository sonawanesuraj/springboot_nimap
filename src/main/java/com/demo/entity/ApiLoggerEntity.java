package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ApiLoggerEntity  {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
    @Column(name = "user_token", length = 512)
	private String userToken; 
    
	@Column(name = "ip_address")
	private String ipAddress;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "host")
	private String host; 
	
	@Column(name = "body")
	private String body; 
	
	@Column(name = "created_at")
	private Date createdAt;
	
	public ApiLoggerEntity(int id, String userToken, String ipAddress, String url, String method, String host,String body, Date createdAt) {
		super();
		this.id = id;
		this.userToken = userToken;
		this.ipAddress = ipAddress;
		this.url = url;
		this.method = method;
		this.host = host;
		this.body = body;
		this.createdAt = createdAt;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
