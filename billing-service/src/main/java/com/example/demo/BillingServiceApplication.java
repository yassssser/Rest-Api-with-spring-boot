package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductItem;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductItemRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InventoryService;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
							CustomerService customerService, InventoryService inventoryService) {
		return args -> {
			Customer c1 = customerService.findCustomerByID(1L);
			Bill b1 = billRepository.save(new Bill(null,new Date(),c1.getId(),null));
			
			PagedModel<Product> products= inventoryService.findAllProducts();
			products.getContent().forEach(p -> {
				productItemRepository.save(new ProductItem(null,p.getId(),p.getPrice(),3,b1));
			});
			/*
			Product p1 = inventoryService.findProductByID(1L);
			productItemRepository.save(new ProductItem(null,p1.getId(),p1.getPrice(),3,b1));
			
			Product p2 = inventoryService.findProductByID(2L);
			productItemRepository.save(new ProductItem(null,p2.getId(),p2.getPrice(),5,b1));
			
			Product p3 = inventoryService.findProductByID(3L);
			productItemRepository.save(new ProductItem(null,p3.getId(),p3.getPrice(),5,b1));
			*/
		};
	}

}
