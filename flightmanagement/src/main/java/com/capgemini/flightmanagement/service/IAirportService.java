package com.capgemini.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.flightmanagement.entity.Airport;

public interface IAirportService {
	
	public List<Airport> viewAirport();
	
	public Optional<Airport> viewAirport(String code);

}
