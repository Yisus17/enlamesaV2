package com.enlamesa.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlamesa.back.model.Product;
import com.enlamesa.back.model.Restaurant;
import com.enlamesa.back.repository.RestaurantRepository;
import com.enlamesa.back.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	
	@RequestMapping(method= RequestMethod.GET)
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) throws Exception{
		return restaurantService.createRestaurant(restaurant);
	}
	
	@RequestMapping(value = "/{id}",method= RequestMethod.PUT)
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable("id")Integer id) {
		return restaurantService.updateRestaurant(restaurant, id);
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public Boolean deleteRestaurant(@PathVariable("id")Integer id) {
		return restaurantService.deleteRestaurant(id);
	}
	
	
}
