package com.example.ezprder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ezprder.model.Shop;
import com.example.ezprder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository shopRepository;
	
	//find all
	public List<Shop> findAll(){
		return shopRepository.findAll();
	}
	//find by shopid
	public Shop findByShopId(long shopId) {
		return shopRepository.findById(shopId).get();
	}
	//토큰 업데이트
	@Transactional
	public void updateTkn(long shopId, String token) {
		Shop shop = shopRepository.findById(shopId).get();
		shop.setToken(token);
	}
}
