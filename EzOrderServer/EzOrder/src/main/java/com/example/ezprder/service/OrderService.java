package com.example.ezprder.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ezprder.model.OrderCount;
import com.example.ezprder.model.OrderInfo;
import com.example.ezprder.repository.OrderCountRepository;
import com.example.ezprder.repository.OrderInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderCountRepository orderCountRepository;
	private final OrderInfoRepository orderInfoRepository;
	
	public void save(OrderInfo orderInfo) {
		OrderInfo nowOrderInfo=orderInfoRepository.save(orderInfo);
		for(OrderCount orderCount : orderInfo.getOrderList()) {
			OrderCount o = new OrderCount(orderCount.getMenu(), orderCount.getCount(),nowOrderInfo);
			orderCountRepository.save(o);
		}
	}
	
}
