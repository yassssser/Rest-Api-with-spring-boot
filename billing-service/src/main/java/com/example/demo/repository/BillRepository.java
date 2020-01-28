package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Bill;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long>{

}
