package com.example.ezprder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ezprder.model.Menu;
import com.example.ezprder.model.Shop;
import com.example.ezprder.service.MenuService;
import com.example.ezprder.service.ShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/menu/*")
@RequiredArgsConstructor
public class MenuController {
	private final MenuService menuService;
	private final ShopService shopService;
	//가게당 메뉴 가져오기
	@GetMapping("list/{shopid}")
	public List<Menu> findByShop(@PathVariable long shopid){
		return menuService.findByShop(shopid);
	}
	@PostMapping("upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
		System.out.println("controller uploadImage");
        String imagePath = menuService.uploadImage(file); // 이미지를 업로드하고 경로를 받아옴
        System.out.println(imagePath);
        return ResponseEntity.ok(imagePath);
	}
	@PostMapping("insert")
	public void saveMenu(@RequestBody Menu menu) {
		Shop shop = shopService.findByShopId(menu.getShop().getShopId());
		menu.setShop(shop);
		menuService.save(menu);
	}
}
