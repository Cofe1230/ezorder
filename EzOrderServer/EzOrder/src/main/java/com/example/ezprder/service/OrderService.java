package com.example.ezprder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ezprder.model.OrderCount;
import com.example.ezprder.model.OrderInfo;
import com.example.ezprder.repository.OrderCountRepository;
import com.example.ezprder.repository.OrderInfoRepository;
import com.example.ezprder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderCountRepository orderCountRepository;
	private final OrderInfoRepository orderInfoRepository;
	
	//주문 번호 생성, 주문 정보 입력
	public void save(OrderInfo orderInfo) {
		OrderInfo nowOrderInfo=orderInfoRepository.save(orderInfo);
		for(OrderCount orderCount : orderInfo.getOrderList()) {
			OrderCount o = new OrderCount(orderCount.getMenu(), orderCount.getCount(),nowOrderInfo);
			orderCountRepository.save(o);
		}
	}
	public List<OrderInfo> findByMemberId(String memberName){
		return orderInfoRepository.findByMemberName(memberName);
	}
	
}
