package com.brunosanttos.mc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunosanttos.mc.domain.City;
import com.brunosanttos.mc.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {
	
	@Autowired
	CityService cityService;
	
	@GetMapping
	public ResponseEntity<List<City>> findAll(){
		List <City> list = cityService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id) {
		City obj = cityService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
