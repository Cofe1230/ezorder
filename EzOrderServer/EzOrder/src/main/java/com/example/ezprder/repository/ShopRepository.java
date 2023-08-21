package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
