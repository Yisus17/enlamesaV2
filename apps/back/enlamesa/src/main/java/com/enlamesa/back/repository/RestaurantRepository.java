package com.enlamesa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlamesa.back.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
