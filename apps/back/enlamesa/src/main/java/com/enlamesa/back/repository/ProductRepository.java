package com.enlamesa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlamesa.back.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
}
