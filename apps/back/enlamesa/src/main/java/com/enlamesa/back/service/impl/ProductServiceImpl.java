package com.enlamesa.back.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	    if(productRepository.existsById(product.getIdProduct())){
	        Product productToUpdate = productRepository.getOne(product.getIdProduct()); 
	        productToUpdate.setName(product.getName());
	        productToUpdate.setDescription(product.getDescription());
	        return productRepository.save(productToUpdate);	
	    }
	    return null;
	}

	@Override
	public Boolean deleteProduct(Long idProduct) {
		if(productRepository.existsById(idProduct)) {
			productRepository.deleteById(idProduct);
			return true;
		}
		return false;
	}

	@Override
	public Product getProductById(Long id) throws Exception{
		Optional<Product> productOpt = productRepository.findById(id);
		Product result = null;
		if(productOpt.isPresent()) {
			result =  productOpt.get();
		}else {
			throw new Exception("Product "+ id+" not found");
		}
		return result;
	}	
}
