package com.enlamesa.back.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.EnlamesaApplication;
import com.enlamesa.back.model.Product;
import com.enlamesa.back.model.Restaurant;
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
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Integer id) {
		Restaurant restaurantToUpdate = new Restaurant();
		
		if(restaurantRepository.existsById(id)){
			restaurantToUpdate = restaurantRepository.getOne(id); 
		}else {
			LOG.info("El restaurant con id "+ id+" no existe. Creando restaurant nuevo");
		}
		restaurantToUpdate.setName(restaurant.getName());
		restaurantToUpdate.setRif(restaurant.getRif());
		restaurantToUpdate.setLatitude(restaurant.getLatitude());
		restaurantToUpdate.setLongitude(restaurant.getLongitude());
		restaurantToUpdate.setSchedule(restaurant.getSchedule());
		restaurantToUpdate.setAddress(restaurant.getAddress());
		return restaurantRepository.save(restaurantToUpdate);	
	}

	@Override
	public Boolean deleteRestaurant(int idRestaurant) {
		if(restaurantRepository.existsById(idRestaurant)) {
			restaurantRepository.deleteById(idRestaurant);
			return true;
		}
		return false;
	}

}
