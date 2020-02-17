package com.enlamesa.back.service;

import com.enlamesa.back.model.Restaurant;
import java.util.List;

public interface RestaurantService {

	List<Restaurant> getRestaurants();

	Restaurant createRestaurant(Restaurant restaurant);
	
	Restaurant updateRestaurant(Restaurant restaurant);
	
	Boolean deleteRestaurant(int idRestaurant);

}
