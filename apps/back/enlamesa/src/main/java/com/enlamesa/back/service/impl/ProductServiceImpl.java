package com.enlamesa.back.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.EnlamesaApplication;
import com.enlamesa.back.model.Product;
import com.enlamesa.back.repository.ProductRepository;
import com.enlamesa.back.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	private static Logger LOG = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);	
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		Product productToUpdate = productRepository.getOne(product.getIdProduct());
		
		productToUpdate.setName(product.getName());
		productToUpdate.setDescription(product.getDescription());
		return productRepository.save(productToUpdate);	
	}

	@Override
	public Boolean deleteProduct(int idProduct) {
		if(productRepository.existsById(idProduct)) {
			productRepository.deleteById(idProduct);
			return true;
		}
		return false;
	}	
}
