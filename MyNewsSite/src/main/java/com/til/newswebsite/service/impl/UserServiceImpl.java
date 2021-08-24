package com.til.newswebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.til.newswebsite.entity.User;
import com.til.newswebsite.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;


	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"Raja","user0", "pwd0", "user0@gmail.com"),
				new User(102,"Ram", "user1", "pwd1", "user1@gmail.com"),
				new User(103,"Mohan", "user2", "pwd2", "user2@gmail.com"),
				new User(104,"Roy","user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> saveUsers (List<User> users){
		return repository.saveAll(users);
	}

}
