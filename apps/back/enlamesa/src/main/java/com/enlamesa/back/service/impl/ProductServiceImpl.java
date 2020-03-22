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
	public Product createProduct(Product product) throws Exception {
		if(product.getName() != null) {
			Product existingProduct = productRepository.findByName(product.getName());
			if(existingProduct == null) {
				return productRepository.save(product);	
			}else {
				throw new Exception("Product "+product.getName() +"already exists");
			}
		}else {
			throw new Exception("Missing products name");
		}
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product, Long id) throws Exception {
	    if(productRepository.existsById(id)){
	        Product productToUpdate = productRepository.getOne(id); 
	        
	        if(product.getName()!=null)
	        	productToUpdate.setName(product.getName());
	        if(product.getDescription() != null)
	        	productToUpdate.setDescription(product.getDescription());
	        
	        return productRepository.save(productToUpdate);	
	    }else {
	    	String errormsg = "El pruducto con id "+ id+" no existe.";
			LOG.info(errormsg);
			throw new Exception(errormsg); 
	    }
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
