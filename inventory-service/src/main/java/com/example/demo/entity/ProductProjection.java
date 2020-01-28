package com.example.demo.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= Product.class)
public interface ProductProjection {

	public String getName();
	public String getPrice();
}
