package com.example.ezprder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderStatus;
	@OneToMany(mappedBy = "orderInfo",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("orderInfo")
	private List<OrderCount> orderList;
	@ManyToOne
	@JoinColumn(name = "shopid")
	private Shop shop;
	public OrderInfo() {
    }
	public OrderInfo(OrderInfo orderInfo) {
		orderStatus = orderInfo.getOrderStatus();
	}
//	@OneToMany(cascade = CascadeType.ALL)
//	@CollectionTable(name="order_item_mapping",
//			joinColumns = {@JoinColumn(name="order_id",referencedColumnName = "id")})
//	@MapKeyJoinColumn(name="menu_id")
//	private Map<Menu, Double> orderItem;
	

}
