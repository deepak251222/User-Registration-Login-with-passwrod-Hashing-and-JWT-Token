package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.Entity.User;
import com.main.service.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/web")

public class WebController {

	@Autowired
	private UserServiceImpl userService;

	String message;

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/search")
	public String userserchform() {
		return "searchform";
	}

	@GetMapping("/login")
	public String login() {
		return "userlogin";
	}

	@GetMapping("/adduser")
	public String addu() {
		return "userform";
	}

	// **** Add Employee ****
	@PostMapping("/add")
	public ModelAndView add(@Valid @ModelAttribute User user, BindingResult errors) {
		// ModelAndView mav = null;

		User u1 = null;
		if (errors.hasErrors()) {
			return new ModelAndView("userform", "user", user);
		}
		try {
			u1 = (User) userService.searchUser(user.getUsername());
			if (u1 == null) {
				u1 = userService.addUser(user);
				message = "User Insertion SuccessFull";
				return new ModelAndView("status", "message", message);

			} else
				message = "User all Ready Exits";
			return new ModelAndView("status", "message", message);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Internal Server Errror";
			return new ModelAndView("status", "message", message);

		}

	}
	@PostMapping("/searchuser")
	public ModelAndView getOne(@PathVariable int uid) {
		User u1 = userService.getOne(uid);
		if (u1 == null) {
			message = "User Not Exits";
			return new ModelAndView("status", "message", message);
		}

		return new ModelAndView("userDetails", "u1", u1);
	}
}
