package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.OrderCount;

public interface OrderCountRepository extends JpaRepository<OrderCount, Long> {

}
