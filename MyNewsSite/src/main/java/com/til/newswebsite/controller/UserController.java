package com.til.newswebsite.controller;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.til.newswebsite.entity.User;
//import com.til.newswebsite.service.UserService;
//
//public class UserController {
//
//	@Autowired
//	private UserService service;
//
//	@PostMapping("/addUser")
//	public User addUser(@RequestBody User user) {
//		return service.saveUser(user);
//	}
//
//	@PostMapping("/addUsers")
//	public List<User> addUsers(@RequestBody List<User> users) {
//		return service.saveUsers(users);
//	}
//}

import com.til.newswebsite.entity.AuthRequest;
import com.til.newswebsite.security.JwtUtil;
import com.til.newswebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService service;

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
			);
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}

		return jwtUtil.generateToken(authRequest.getUserName());
	}
}