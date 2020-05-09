package com.capgemini.flightmanagement.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Booking;
import com.capgemini.flightmanagement.entity.FlightSchedule;
import com.capgemini.flightmanagement.entity.Passenger;
import com.capgemini.flightmanagement.exception.BookingException;
import com.capgemini.flightmanagement.service.IBookingService;
import com.capgemini.flightmanagement.service.IFlightScheduleService;
import com.capgemini.flightmanagement.service.IPassengerService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	private static final Logger log=LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private IFlightScheduleService flightScheduleService;
	
	@Autowired
	private IPassengerService passengerService;
	

	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		
		log.debug("Inside addBooking method in BookingController class");
		
		List<Passenger> passengerList=booking.getPassengerList();
		FlightSchedule flightSchedule=booking.getFlightSchedule();
		passengerService.saveAll(passengerList);
		int passengerCount=booking.getNoOfPassengers();
		booking.setBookingDate(LocalDate.now());
		flightSchedule.setAvailableSeats(flightSchedule.getAvailableSeats()-passengerCount);
		flightScheduleService.modifyScheduledFlight(flightSchedule);
		bookingService.addBooking(booking);
		return booking;
		
	}
	
	@GetMapping("/viewById")
	public Booking viewById(@RequestParam("id")int bookingId) throws BookingException{
		
		log.debug("Inside viewById method in BookingController class");
		
		Booking booking=bookingService.viewBooking(bookingId);
		
		if(booking!=null) {
			return booking;
		}
		else {
			throw new BookingException();
		}
		
	}
	
	@GetMapping("/deleteById")
	public String deleteById(@RequestParam("id")int bookingId) {
		
		log.debug("Inside deleteById method in BookingController class");
		
		Booking booking=bookingService.viewBooking(bookingId);
		FlightSchedule flightSchedule=booking.getFlightSchedule();
		int count=booking.getNoOfPassengers();
		flightSchedule.setAvailableSeats(flightSchedule.getAvailableSeats()+count);
		flightScheduleService.modifyScheduledFlight(flightSchedule);
		bookingService.deleteBooking(bookingId);
		
		return "deleted successfully";
		
	}
	
	@GetMapping("/viewByUserId")
	public List<Booking> viewByUserId(@RequestParam("userId")BigInteger userId) throws BookingException{
		
		log.debug("Inside viewByUserId method in BookingController class");
		
		List<Booking> bookingList=bookingService.viewAllBooking(userId);
		
		if(bookingList.isEmpty()) {
			throw new BookingException();
		}
		else {
			return bookingList;
		}
	}

}
