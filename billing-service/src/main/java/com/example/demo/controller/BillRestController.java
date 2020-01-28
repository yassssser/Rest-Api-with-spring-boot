package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bill;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductItemRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InventoryService;

@RestController
public class BillRestController {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ProductItemRepository productItemRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("fullBill/{id}")
	public Bill getBill(@PathVariable(name="id") Long id) {
		Bill bill = billRepository.findById(id).get();
		bill.setCustomer(customerService.findCustomerByID(bill.getCostumerID()));
		bill.getProductItems().forEach(pi -> {
			pi.setProducts(inventoryService.findProductByID(pi.getProductID()));
		});
		return bill;
	}
	
	
}
