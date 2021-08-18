package com.til.newswebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.til.newswebsite.entity.User;
import com.til.newswebsite.service.UserService;

public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return service.saveUsers(users);
	}
}
