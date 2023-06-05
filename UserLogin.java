package com.main.Entity;

import org.springframework.stereotype.Component;
@Component
public class UserLogin {
	private String username;
	private String upwd;
	private String accessToken;
	   
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public UserLogin(String username, String upwd) {
		super();
		this.username = username;
		this.upwd = upwd;
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", upwd=" + upwd + "]";
	}
	

}
