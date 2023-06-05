package com.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.main.Entity.User;
import com.main.Entity.UserLogin;
import com.main.message.LoginMessage;

public interface UserService {
	
	public List<User> allUser();
	public User getOne(int uid);
	public User addUser(User user);
	public LoginMessage loginUser(UserLogin userLogin);
	public User searchUser(String username);
	
	public ResponseEntity<?> tokenG(UserLogin userLogin);
	
}
