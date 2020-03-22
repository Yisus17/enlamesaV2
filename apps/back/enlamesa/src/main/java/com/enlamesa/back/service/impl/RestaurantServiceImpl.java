package com.enlamesa.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.EnlamesaApplication;
import com.enlamesa.back.model.Product;
import com.enlamesa.back.model.Restaurant;
import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.RestaurantRepository;
import com.enlamesa.back.service.RestaurantService;

@Service
public class RestaurantServiceImpl  implements RestaurantService {

	private static Logger LOG = LoggerFactory.getLogger(RestaurantService.class);

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) throws Exception {
		if(restaurant.getName() != null) {
			Restaurant existingRestaurant = restaurantRepository.findByName(restaurant.getName());
			if(existingRestaurant == null) {
				return restaurantRepository.save(restaurant);	
			}else {
				throw new Exception("Restaurant "+restaurant.getName() +"already exists");
			}
		}else {
			throw new Exception("Missing restaurant name");
		}
	}

	
	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) throws Exception {
	    if(restaurantRepository.existsById(id)){
	    	Restaurant restaurantToUpdate = restaurantRepository.getOne(id); 
	        
	        if(restaurant.getName()!=null)
	        	restaurantToUpdate.setName(restaurant.getName());
	        
	        if(restaurant.getRif()!=null)
	        	restaurantToUpdate.setRif(restaurant.getRif());
			
	        if(restaurant.getLatitude()!=null)
	        	restaurantToUpdate.setLatitude(restaurant.getLatitude());
			
	        if(restaurant.getLongitude()!=null)
	        	restaurantToUpdate.setLongitude(restaurant.getLongitude());
			
	        if(restaurant.getSchedule()!=null)
	        	restaurantToUpdate.setSchedule(restaurant.getSchedule());
			
	        if(restaurant.getAddress()!=null)
	        	restaurantToUpdate.setAddress(restaurant.getAddress());
	        
	        return restaurantRepository.save(restaurantToUpdate);	
	    }else {
	    	String errormsg = "El restaurant con id "+ id+" no existe.";
			LOG.info(errormsg);
			throw new Exception(errormsg); 
	    }
	}
	
	
	@Override
	public Boolean deleteRestaurant(Long idRestaurant) throws Exception {
		if(restaurantRepository.existsById(idRestaurant)) {
			restaurantRepository.deleteById(idRestaurant);
			return true;
		}
		return false;
	}

	@Override
	public Restaurant getRestaurantById(Long id) throws Exception {
		Optional<Restaurant> restaurantOpt = restaurantRepository.findById(id);
		Restaurant result = null;
		if(restaurantOpt.isPresent()) {
			return restaurantOpt.get();
		}else {
			throw new Exception("Restaurant "+ id+" not found");
		}
	}

}
