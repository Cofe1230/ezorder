package com.example.ezprder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezprder.model.OrderInfo;
import com.example.ezprder.service.OrderService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/order/*")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	
	//사용자(일반)가 가게에서 주문했을때 db로 주문 정보 입력
	@PutMapping("insert")
	public void save(@RequestBody OrderInfo orderInfo){
		OrderInfo o = new OrderInfo(orderInfo);
		orderService.save(orderInfo);
	}
	//memberId로 주문정보 리스트
	@GetMapping("list/{memberName}")
	public List<OrderInfo> OrderInfoListByMemberId(@PathVariable String memberName){
		
		return orderService.findByMemberId(memberName);
	}
}
