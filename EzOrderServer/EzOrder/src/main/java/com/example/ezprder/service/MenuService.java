package com.example.ezprder.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	private static String UPLOADPATH = "C:\\androidtest\\EzOrderServer\\EzOrder\\src\\main\\resources\\static\\image";
	
	
	//가게id로 메뉴 전체보기
	public List<Menu> findByShop(long shopid){
		Shop shop = shopRepository.findById(shopid).get();
		return menuRepository.findByShop(shop);
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
	public void save(Menu menu) {
		menuRepository.save(menu);
	}

}
