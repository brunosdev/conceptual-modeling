package com.brunosanttos.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosanttos.mc.domain.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
