package com.enlamesa.back.service;

import com.enlamesa.back.model.Restaurant;
import java.util.List;

public interface RestaurantService {

	List<Restaurant> getRestaurants();
	
	Restaurant getRestaurantById(Long id) throws Exception;

	Restaurant createRestaurant(Restaurant restaurant) throws Exception;
	
	Restaurant updateRestaurant(Restaurant restaurant, Long id) throws Exception;
	
	Boolean deleteRestaurant(Long idRestaurant) throws Exception;

}
