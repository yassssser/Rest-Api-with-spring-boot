package com.example.demo.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1", types= Customer.class)
public interface CustomerProjection {

	public String getID();
	public String getName();
}
