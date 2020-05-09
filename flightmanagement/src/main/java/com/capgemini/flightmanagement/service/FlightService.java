package com.capgemini.flightmanagement.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.capgemini.flightmanagement.entity.Flight;
import com.capgemini.flightmanagement.repository.IFlightRepository;



@Service
public class  FlightService  implements IFlightService{
	
	private static final Logger log=LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private IFlightRepository  flightRepository;
		
	@Override
	@Transactional
	public List<Flight> viewFlight() {
		
		
			
		return flightRepository.findAll();
	}
                                                                               
	@Override
	@Transactional
	public Flight addFlight(Flight theFlight) {
		
		log.debug("Inside addFlight method in FlightService class");
		flightRepository.save(theFlight);	
		
		return theFlight;
	}

	@Override
	@Transactional
	public Optional<Flight> viewFlight(BigInteger theFlightNumber) {
		
		log.debug("Inside viewFlightmethod by Flight Number in FlightService class");
		Optional<Flight> flightObj=flightRepository.findById(theFlightNumber);
		return flightObj;
	}

	@Override
	@Transactional
	public void deleteFlight(BigInteger FlightNumber) {
		
		log.debug("Inside deleteFlight method in FlightService class");
		
		flightRepository.deleteById(FlightNumber);			
	}
		
	@Override
	@Transactional
	public Flight modifyFlight(Flight newFlight) {
	 
		log.debug("Inside modifyFlight method in FlightService class");
		
	    flightRepository.save(newFlight);
	        
	        return newFlight;
	    }

	
	 
	}
