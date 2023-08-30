package com.example.ezprder.service;

import org.springframework.stereotype.Service;

import com.example.ezprder.model.User;
import com.example.ezprder.repository.ShopRepository;
import com.example.ezprder.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final ShopRepository shopRepository;
	
	//로그인
	public long login(User user) {
		long shopId=-1;
		User findUser = userRepository.findByUserName(user.getUserName());
		if(findUser==null)
			return shopId;
		if(!user.getPassword().equals(findUser.getPassword()))
			return shopId;
		shopId=shopRepository.findByUser(findUser).getShopId();
		return shopId;
	}
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
