package com.brunosanttos.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.domain.State;
import com.brunosanttos.mc.repositories.StateRepository;
import com.brunosanttos.mc.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State> findAll() {
		return repository.findAll();
	}
	
	public State findById(Integer id) {
		Optional<State> state = repository.findById(id);
		return state.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}

