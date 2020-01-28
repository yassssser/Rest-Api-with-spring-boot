package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;

@FeignClient( name = "CUSTOMER-SERVICE" )
public interface CustomerService {

	@GetMapping("/customers/{id}")
	public Customer findCustomerByID(@PathVariable(name="id") Long id);
}
