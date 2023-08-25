package com.example.ezprder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ezprder.model.Shop;
import com.example.ezprder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository shopRepository;
	
	public List<Shop> findAll(){
		return shopRepository.findAll();
	}

}
