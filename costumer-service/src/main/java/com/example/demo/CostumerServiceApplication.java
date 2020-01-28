package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class CostumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostumerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfig) {
		return args -> {
			restConfig.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"yasser","yasserbenmman@gmail.com"));
			customerRepository.save(new Customer(null,"ibm","yasserbenmman@gmail.com"));
			customerRepository.save(new Customer(null,"dell","yasserbenmman@gmail.com"));
			
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
