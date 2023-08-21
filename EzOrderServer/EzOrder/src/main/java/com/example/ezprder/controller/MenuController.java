package com.example.ezprder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezprder.model.Menu;
import com.example.ezprder.model.Shop;
import com.example.ezprder.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/menu/*")
@RequiredArgsConstructor
public class MenuController {
	private final MenuService menuService;
	//가게당 메뉴 가져오기
	@GetMapping("list/{shopid}")
	public List<Menu> findByShop(@PathVariable long shopid){
		
		return menuService.findByShop(shopid);
	}
}
