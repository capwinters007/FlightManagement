package com.capgemini.flightmanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler({FlightNotFoundException.class,FlightScheduleNotFoundException.class,BookingException.class})
	public String handleException(Exception ex){
		if(ex instanceof FlightNotFoundException)
		{
			return "No Flight Exists of this ID!!";
		}
		
		else if(ex instanceof FlightScheduleNotFoundException) {
			
			return "No Flight Schedule Exists of this ID!!";
		}
		
		else if(ex instanceof BookingException) {
			return "No Booking Exists of this ID!!";
		}
		else {
			return null;
		}
	}

}
