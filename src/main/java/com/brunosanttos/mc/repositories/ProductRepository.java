package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
