package com.example.ezprder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Shop {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shopId;
	private String shopName;
	private double latitude;
	private double longitude;
	private String shopImg;
	@OneToOne
	@JoinColumn(name = "userid")
	private User user;
	@OneToMany(mappedBy = "shop",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("shop")
	private List<Menu> menuList;
	@OneToMany(mappedBy = "shop",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("shop")
	private List<OrderInfo> orderList;
	@Builder.Default
	private String token = "none";

	
	
	
}
