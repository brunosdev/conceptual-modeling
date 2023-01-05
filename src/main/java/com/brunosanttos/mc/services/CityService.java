package com.brunosanttos.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.domain.City;
import com.brunosanttos.mc.repositories.CityRepository;
import com.brunosanttos.mc.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	public List<City> findAll() {
		return repository.findAll();
	}
	
	public City findById(Integer id) {
		Optional<City> city = repository.findById(id);
		return city.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}

