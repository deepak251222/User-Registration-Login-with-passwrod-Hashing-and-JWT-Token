package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.Entity.User;
import com.main.Entity.UserLogin;
import com.main.dao.UserDao;
import com.main.message.LoginMessage;
import com.main.secrity.JwtUnit;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUnit jwtUtil;

	@Autowired
	private UserDao userDao;

	@Autowired(required = true)
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<?> tokenG(UserLogin userLogin) {

		try {
			System.out.println(userLogin.getUsername());
			System.out.println(userLogin.getUpwd());
			User username = userDao.findByUsername(userLogin.getUsername());
			System.out.println(username.getUsername());
			System.out.println(username.getUpwd());
			System.out.println(passwordEncoder.matches(userLogin.getUpwd(), username.getUpwd()));
			if (username == null || !passwordEncoder.matches(userLogin.getUpwd(), username.getUpwd())) {

				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invilid user name");

			}

			//String token = jwtUtil.generateToken(username.getUsername());
			String token = jwtUtil.generateToken(username);

			UserLogin userlogin = new UserLogin();
			userlogin.setAccessToken(token);
			userlogin.setUpwd(username.getUpwd());
			userlogin.setUsername(username.getUsername());

			return ResponseEntity.ok(userlogin);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");
		}

	}

	@Override
	public User addUser(User user) {

   //	User user1=new User(user.getUid(),user.getUser_name(),
    // user.getUage(),user.getUcity(),user.getUsername(),passwordEncoder.encode(user.getUpwd()));//
		String encode = passwordEncoder.encode(user.getUpwd());
		user.setUpwd(encode);
		User u1 = userDao.save(user);
		System.out.print("service");
		return u1;
	}

	// ***** Login page *****
	@Override
	public LoginMessage loginUser(UserLogin userLogin) {
		String msg = "";
		User user1 = userDao.findByUsername(userLogin.getUsername());
		if (user1 != null) {
			String password = userLogin.getUpwd();
			String encodedPassword = user1.getUpwd();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> user = userDao.findOneByUsernameAndUpwd(userLogin.getUsername(), encodedPassword);
				if (user.isPresent()) {
					return new LoginMessage("Login Success", true);
				} else {
					return new LoginMessage("Login Failed", false);
				}
			} else {

				return new LoginMessage("password Not Match", false);
			}
		} else {
			return new LoginMessage("Email not exits", false);
		}

	}

	@Override
	public List<User> allUser() {
		List<User> u1 = (List<User>) userDao.findAll();
		return u1;
	}

	@Override
	public User getOne(int uid) {
		User u1 = null;
		try {
			u1 = userDao.findByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public User searchUser(String username) {
		User u1 = null;
		u1 = userDao.findByUsername(username);
		return u1;
	}

}
