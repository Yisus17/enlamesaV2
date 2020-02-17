package com.enlamesa.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRestaurant;
	
	@Column(name="name", unique = true)
	private String name;
	
	@Column(name="rif")
	private String rif;
	
	@Column(name="latitude")
	private Float latitude;
	
	@Column(name="longitude")
	private Float longitude;
	
	@Column(name="schedule")
	private String schedule;
	
	@Column(name="address")
	private String address;

	public Restaurant(Integer idRestaurant, String name, String rif, Float latitude, Float longitude, String schedule,
			String address) {
		super();
		this.idRestaurant = idRestaurant;
		this.name = name;
		this.rif = rif;
		this.latitude = latitude;
		this.longitude = longitude;
		this.schedule = schedule;
		this.address = address;
	}

	public Restaurant() {
		super();
		
		
		this.setLatitude((float) 10.368358);
		this.setLongitude((float) -66.944095);
	}

	public Integer getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(Integer idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
