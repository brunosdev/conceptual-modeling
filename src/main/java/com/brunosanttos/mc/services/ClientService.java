package com.brunosanttos.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.domain.Client;
import com.brunosanttos.mc.repositories.ClientRepository;
import com.brunosanttos.mc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Integer id) {
		Optional<Client> client = repository.findById(id);
		return client.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}
