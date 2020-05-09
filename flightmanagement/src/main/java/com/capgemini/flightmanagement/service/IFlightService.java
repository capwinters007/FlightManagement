package com.capgemini.flightmanagement.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.capgemini.flightmanagement.entity.Flight;



public interface IFlightService {
	
		public List<Flight> viewFlight();
		
		public Flight addFlight(Flight theflight);
		
		public Optional<Flight> viewFlight(BigInteger flightNumber);
		
		public void deleteFlight(BigInteger FlightNumber);
		
		public Flight modifyFlight(Flight flight);
		
		
	}
