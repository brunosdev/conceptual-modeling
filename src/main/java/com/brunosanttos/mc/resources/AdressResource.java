package com.brunosanttos.mc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunosanttos.mc.domain.Adress;
import com.brunosanttos.mc.services.AdressService;

@RestController
@RequestMapping(value = "/adresses")
public class AdressResource {

	@Autowired
	AdressService adressService;
	
	@GetMapping
	public ResponseEntity<List<Adress>> findAll(){
		List <Adress> list = adressService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id) {
		Adress obj = adressService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
