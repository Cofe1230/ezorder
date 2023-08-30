package com.example.ezprder.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ezprder.model.Shop;
import com.example.ezprder.model.User;
import com.example.ezprder.service.ShopService;
import com.example.ezprder.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop/*")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService shopService;
	private final UserService userService;
	
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
	@PostMapping("upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
		System.out.println("controller uploadImage");
        String imagePath = shopService.uploadImage(file); // 이미지를 업로드하고 경로를 받아옴
        System.out.println(imagePath);
        return ResponseEntity.ok(imagePath);
	}
	@PostMapping("insert")
	public void insertShop(@RequestBody Shop shop) {
		User user = shop.getUser();
		User newUser = userService.saveUser(user);
		shop.setUser(newUser);
		shopService.saveShop(shop);
	}

}
