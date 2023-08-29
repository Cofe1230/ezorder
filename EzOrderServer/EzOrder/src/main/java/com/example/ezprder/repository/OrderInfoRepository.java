package com.example.ezprder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.Member;
import com.example.ezprder.model.OrderInfo;
import com.example.ezprder.model.Shop;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
	List<OrderInfo> findByMemberOrderByOrderIdDesc(Member member);
	List<OrderInfo> findByShopOrderByOrderIdDesc(Shop shop);
}
