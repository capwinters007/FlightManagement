package com.capgemini.flightmanagement.controller;

import java.time.LocalDate;
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

import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.entity.Flight;
import com.capgemini.flightmanagement.entity.FlightSchedule;
import com.capgemini.flightmanagement.exception.FlightScheduleNotFoundException;
import com.capgemini.flightmanagement.service.IFlightScheduleService;
import com.capgemini.flightmanagement.service.IFlightService;



@RestController
@RequestMapping("/flightSchedule")
public class FlightScheduleController {
	
	private static final Logger log=LoggerFactory.getLogger(FlightScheduleController.class);
	
	@Autowired
	private IFlightScheduleService flightScheduleServive;
	
	@Autowired
	private IFlightService flightService;

	@PostMapping(path="/add")
	public String add(@RequestBody FlightSchedule flightSchedule)
	{
		
		log.debug("Inside add method in controller class");
		
		String validate=flightScheduleServive.validateScheduledFlight(flightSchedule);
		
		if("valid data".equals(validate)) {
			
			Optional<Flight> FlightOpt=flightService.viewFlight(flightSchedule.getFlight().getFlightNumber());
			flightSchedule.setAvailableSeats(FlightOpt.get().getSeatCapacity());
			flightScheduleServive.scheduleFlight(flightSchedule);
			validate="Added successfully";
		}
		
		
		return validate;
		
	}
	
	@GetMapping("/viewByAirport")
	public List<FlightSchedule> getFlightOnDate(){
		
		
		Airport airport1=new Airport("BOM",null,null);
		Airport airport2=new Airport("NDL",null,null);
		
		LocalDate date=LocalDate.of(2020, 05, 10);
		
		List<FlightSchedule> FlightScheduleList=flightScheduleServive.viewScheduledFlights(airport2,airport1,date);
		
		return FlightScheduleList;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws FlightScheduleNotFoundException {
		
		log.debug("Inside delete method in controller class");
		
		Optional<FlightSchedule> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		
		flightScheduleServive.deleteScheduledFlight(id);
		
		return "Deleted succesfully";
	}
	
	@PostMapping("/update")
	public String update(@RequestBody FlightSchedule flightSchedule) {
		
		log.debug("Inside update method in controller class");
		
		flightScheduleServive.modifyScheduledFlight(flightSchedule);
		
		return "updated";
		
	}
	@GetMapping("/viewById")
	public FlightSchedule getFlightScheduleById(@RequestParam("id")int id) throws FlightScheduleNotFoundException{
		
		log.debug("Inside getFlightScheduleById in controller class");
		
		Optional<FlightSchedule> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		FlightSchedule flightSchedule=flightScheduleOpt.get();
		
		return flightSchedule;
	}
	
}

