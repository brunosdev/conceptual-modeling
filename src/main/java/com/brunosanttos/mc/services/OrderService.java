package com.brunosanttos.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosanttos.mc.domain.Adress;
import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.domain.Order;
import com.brunosanttos.mc.repositories.OrderRepository;
import com.brunosanttos.mc.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> ord = repository.findById(id);
		return ord.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}


