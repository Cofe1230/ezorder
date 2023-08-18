package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

}
