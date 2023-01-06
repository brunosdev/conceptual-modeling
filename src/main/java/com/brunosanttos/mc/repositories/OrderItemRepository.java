package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
