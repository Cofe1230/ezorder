package com.example.ezprder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ezprder.model.Menu;
import com.example.ezprder.model.Shop;
import com.example.ezprder.repository.MenuRepository;
import com.example.ezprder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
	private final MenuRepository menuRepository;
	private final ShopRepository shopRepository;
	
	public List<Menu> findByShop(long shopid){
		Shop shop = shopRepository.findById(shopid).get();
		return menuRepository.findByShop(shop);
	}

}
