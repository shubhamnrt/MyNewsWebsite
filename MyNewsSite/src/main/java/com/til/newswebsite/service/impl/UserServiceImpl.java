package com.til.newswebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.til.newswebsite.entity.User;
import com.til.newswebsite.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> saveUsers (List<User> users){
		return repository.saveAll(users);
	}

}
