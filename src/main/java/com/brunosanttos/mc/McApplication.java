package com.brunosanttos.mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunosanttos.mc.domain.Adress;
import com.brunosanttos.mc.domain.Category;
import com.brunosanttos.mc.domain.City;
import com.brunosanttos.mc.domain.Client;
import com.brunosanttos.mc.domain.Order;
import com.brunosanttos.mc.domain.Payment;
import com.brunosanttos.mc.domain.PaymentCard;
import com.brunosanttos.mc.domain.PaymentSlip;
import com.brunosanttos.mc.domain.Product;
import com.brunosanttos.mc.domain.State;
import com.brunosanttos.mc.domain.enums.ClientType;
import com.brunosanttos.mc.domain.enums.PaymentStatus;
import com.brunosanttos.mc.repositories.AdressRepository;
import com.brunosanttos.mc.repositories.CategoryRepository;
import com.brunosanttos.mc.repositories.CityRepository;
import com.brunosanttos.mc.repositories.ClientRepository;
import com.brunosanttos.mc.repositories.OrderRepository;
import com.brunosanttos.mc.repositories.PaymentRepository;
import com.brunosanttos.mc.repositories.ProductRepository;
import com.brunosanttos.mc.repositories.StateRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	AdressRepository adressRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "Computing");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Belo Horizonte", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Campinas", s2);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "25895168725", ClientType.NATURALPERSON);
		cli1.getPhones().addAll(Arrays.asList("558597845965", "558598785236"));
		
		Adress a1 = new Adress(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Adress a2 = new Adress(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAdresses().addAll(Arrays.asList(a1, a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		adressRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Order o1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		Order o2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, a2);
		
		Payment pay1 = new PaymentCard(null, PaymentStatus.SETTLED, o1, 6);
		
		o1.setPayment(pay1);
		
		Payment pay2 = new PaymentSlip(null, PaymentStatus.PENDING, o2, sdf.parse("20/10/2017 00:00"), null);
		
		o2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(o1, o2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
	}
}
