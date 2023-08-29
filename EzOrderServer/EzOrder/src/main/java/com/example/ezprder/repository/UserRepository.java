package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
	
}
