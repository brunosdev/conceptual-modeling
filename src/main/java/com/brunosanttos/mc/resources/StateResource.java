package com.brunosanttos.mc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunosanttos.mc.domain.State;
import com.brunosanttos.mc.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateResource {
	
	@Autowired
	StateService stateService;
	
	@GetMapping
	public ResponseEntity<List<State>> findAll(){
		List <State> list = stateService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id) {
		State obj = stateService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
