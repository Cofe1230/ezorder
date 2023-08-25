package com.example.ezprder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezprder.model.User;
import com.example.ezprder.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	//flag = 1; 로그인 실패 0:로그인 성공
	@PostMapping("login")
	public long login(@RequestBody User user) {
		return userService.login(user);
	}
}
