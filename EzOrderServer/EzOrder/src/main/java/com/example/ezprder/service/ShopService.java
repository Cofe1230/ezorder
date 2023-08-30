package com.example.ezprder.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ezprder.model.Shop;
import com.example.ezprder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository shopRepository;
	private static String UPLOADPATH = "C:\\androidtest\\EzOrderServer\\EzOrder\\src\\main\\resources\\static\\image";
	
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
	public String uploadImage(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String uploadFileName = "";
		
		if(!file.isEmpty()) {
			uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
			File saveFile = new File(UPLOADPATH,uploadFileName);
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return uploadFileName;
	}
	public void saveShop(Shop shop) {
		shopRepository.save(shop);
	}
}
