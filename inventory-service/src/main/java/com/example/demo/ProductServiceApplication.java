package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfig) {
		return args -> {
			restConfig.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"pc hp",2500));
			productRepository.save(new Product(null,"pc alience",8000));
			productRepository.save(new Product(null,"MacPro",6500));
			
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
