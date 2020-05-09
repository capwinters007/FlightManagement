package com.capgemini.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.repository.IAirportRepository;



@Service
public class  AirportService  implements IAirportService{
	
	@Autowired
	private IAirportRepository  airportRepository;
		
		@Override
		@Transactional
		public List<Airport> viewAirport() {
			
			return airportRepository.findAll();
		}
		
		@Override
		@Transactional
		public Optional<Airport> viewAirport(String Code) {
	
			Optional<Airport> airportObj=airportRepository.findById(Code);
			
			return airportObj;
		}

}
