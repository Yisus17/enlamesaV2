package com.enlamesa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlamesa.back.model.Product;

public interface CommentRepository extends JpaRepository<Product, Long>{

}
