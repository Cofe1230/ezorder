package com.example.ezprder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

}
