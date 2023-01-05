package com.brunosanttos.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.repositories.CategoryRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "Tools");
		Category cat3 = new Category(null, "Computing");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
