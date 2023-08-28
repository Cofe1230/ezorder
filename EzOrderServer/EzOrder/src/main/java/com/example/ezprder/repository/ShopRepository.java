package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.Shop;
import com.example.ezprder.model.User;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	Shop findByUser(User user);
}
