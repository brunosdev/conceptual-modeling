package com.brunosanttos.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunosanttos.mc.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public List<Category>list() {
		Category cat1 = new Category(1, "Office");
		Category cat2 = new Category(2, "TV & Video");
		
		List<Category> ls = new ArrayList<>();
		
		ls.add(cat1);
		ls.add(cat2);
			
		return ls;
	}
}
