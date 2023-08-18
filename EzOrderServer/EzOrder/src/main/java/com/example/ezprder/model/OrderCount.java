package com.example.ezprder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderCountid;
	@OneToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;
	private int count;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderInfo orderInfo;
	public OrderCount(Menu menu, int count, OrderInfo orderInfo) {
		super();
		this.menu = menu;
		this.count = count;
		this.orderInfo = orderInfo;
	}
	
	
	
	
}
