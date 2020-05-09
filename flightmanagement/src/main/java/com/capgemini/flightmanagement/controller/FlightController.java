package com.capgemini.flightmanagement.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Flight;
import com.capgemini.flightmanagement.exception.FlightNotFoundException;
import com.capgemini.flightmanagement.service.IFlightService;





@RestController
@RequestMapping("/Flight")
public class FlightController {
 
		private static final Logger log =LoggerFactory.getLogger(FlightController.class);
		
		@Autowired
		private IFlightService flightService;
		
		
		@PostMapping("/add")
		public Flight indexPost(@RequestBody Flight flightObj)
		{
			log.debug("Inside indexPost method in FlightController class");
			
			return flightService.addFlight(flightObj);
			
			
		}
		
		@GetMapping("/viewFlights")
		public List<Flight> listOfFlights(){
			
			log.debug("Inside listOfFlights method in FlightController class");
			return flightService.viewFlight();
			
		}
		
		
		@GetMapping("/viewFlightByNumber")
		public Optional<Flight> findOne(@RequestParam("flightNumber") BigInteger flightNumber) throws FlightNotFoundException
		{
			log.debug("Inside findOne method in FlightController class");
			Optional<Flight> FlightOpt = flightService.viewFlight(flightNumber);
			if(!FlightOpt.isPresent())
				throw new FlightNotFoundException();
			return FlightOpt;
		}
		
		
		@GetMapping("/deleteFlightByNumber")
		public String delete(@RequestParam("flightNumber")BigInteger flightNumber)
		{
			log.debug("Inside delete method in FlightController class");
			flightService.deleteFlight(flightNumber);
			
			return "deleted Successfully";
		}
		
		
		@GetMapping("/updateFlight")
	    Flight updateFlight(@RequestBody Flight newFlight) {
	 
			log.debug("Inside updateFlight method in FlightController class");
	       return flightService.modifyFlight( newFlight);
		}
	 }

