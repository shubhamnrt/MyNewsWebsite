package com.til.newswebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.til.newswebsite.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
