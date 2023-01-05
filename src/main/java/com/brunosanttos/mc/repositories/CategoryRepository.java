package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
