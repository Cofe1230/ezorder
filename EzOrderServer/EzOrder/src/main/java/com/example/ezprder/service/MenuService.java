package com.example.ezprder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ezprder.model.Menu;
import com.example.ezprder.model.Shop;
import com.example.ezprder.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
	private final MenuRepository menuRepository;
	
	public List<Menu> findByShopId(Shop shop){
		return menuRepository.findByShopId(shop);
	}

}
