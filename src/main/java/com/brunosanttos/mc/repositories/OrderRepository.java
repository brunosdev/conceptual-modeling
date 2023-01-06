package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
