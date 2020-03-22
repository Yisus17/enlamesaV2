package com.enlamesa.back.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlamesa.back.model.Product;

@RestController
@RequestMapping("api/public")
public class PromoController {

	@RequestMapping(value = "/promo",method= RequestMethod.GET)
	public String getPromos(){
		return "LISTADO PROMO";
	}
	
}
