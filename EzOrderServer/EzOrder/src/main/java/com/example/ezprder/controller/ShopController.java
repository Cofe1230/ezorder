package com.example.ezprder.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezprder.model.Shop;
import com.example.ezprder.service.ShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop/*")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService shopService;
	
	@GetMapping("list")
	public List<Shop> findAll(){
		return shopService.findAll();
	}
	@GetMapping("view/{shopId}")
	public Shop findByShopId(@PathVariable long shopId) {
		return shopService.findByShopId(shopId);
	}
	@GetMapping("updateTkn")
	public void updateTkn(String token,long shopId) {
		shopService.updateTkn(shopId, token);
	}

}
