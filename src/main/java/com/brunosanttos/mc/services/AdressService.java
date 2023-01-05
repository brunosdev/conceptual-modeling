package com.brunosanttos.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosanttos.mc.domain.Adress;
import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.repositories.AdressRepository;
import com.brunosanttos.mc.services.exceptions.ObjectNotFoundException;

@Service
public class AdressService {
	
	@Autowired
	private AdressRepository repository;
	
	public List<Adress> findAll() {
		return repository.findAll();
	}
	
	public Adress findById(Integer id) {
		Optional<Adress> adr = repository.findById(id);
		return adr.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}


