package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Bill {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date billingDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long costumerID;
	
	@Transient
	private Customer customer;
	
	@OneToMany(mappedBy="bill")
	private Collection<ProductItem> productItems;
	
	public Bill() {
		super();
	}

	public Bill(Long id, Date billingDate, Long costumerID, Collection<ProductItem> productItems) {
		super();
		this.id = id;
		this.billingDate = billingDate;
		this.costumerID = costumerID;
		this.productItems = productItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Long getCostumerID() {
		return costumerID;
	}

	public void setCostumerID(Long costumerID) {
		this.costumerID = costumerID;
	}

	public Collection<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
