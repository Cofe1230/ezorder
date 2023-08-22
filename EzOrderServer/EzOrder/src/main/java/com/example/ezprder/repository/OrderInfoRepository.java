package com.example.ezprder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
	List<OrderInfo> findByMemberNameOrderByOrderIdDesc(String memberName);
}
