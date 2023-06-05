package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.main.Entity.User;
import com.main.Entity.UserLogin;
import com.main.message.LoginMessage;
import com.main.service.UserServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/token")
  public ResponseEntity<?> token( @RequestBody UserLogin userLogin){
       return userService.tokenG(userLogin);
  }
	//**** user login ****
     @PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLogin userLogin)
	{
		LoginMessage loginMessage =userService.loginUser(userLogin);
		
		return ResponseEntity.ok(loginMessage);
	}
	
	

	// ******* Getting value ********
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser() {
		List<User> u1 = userService.allUser();
		if (u1.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(u1));
	}
 //  ***** Searching *******
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getOne(@PathVariable int uid) {
		User u1 = userService.getOne(uid);
		if (u1 == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(u1));
	} 
	
	
	
	
	// ****** add User ******
	@PostMapping("/user")
	public ResponseEntity<?> addU(@Valid @RequestBody User user) {
		User u1 = null;
		try {
			u1 = (User) userService.searchUser(user.getUsername());
			if (u1 == null) {
				u1 = userService.addUser(user);
				
				return ResponseEntity.of(Optional.of(u1));

			} else
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("User AlReady Exited");//.build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

}
