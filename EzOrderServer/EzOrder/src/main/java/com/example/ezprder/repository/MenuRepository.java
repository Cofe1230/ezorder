package com.example.ezprder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.Menu;
import com.example.ezprder.model.Shop;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	List<Menu> findByShop(Shop shop);
}
