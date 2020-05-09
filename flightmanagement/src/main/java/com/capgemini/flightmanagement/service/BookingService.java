package com.capgemini.flightmanagement.service;


import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.flightmanagement.entity.Booking;
import com.capgemini.flightmanagement.repository.IBookingRespository;



@Service
public class BookingService implements IBookingService{
	
	private static final Logger log=LoggerFactory.getLogger(BookingService.class);
	
	
	@Autowired
	private IBookingRespository bookingRepository;
	
	@Override
	@Transactional
	public Booking addBooking(Booking booking) {
		
		log.debug("Inside addBooking method in BookingService class");
		
		bookingRepository.save(booking);
		
		return booking;
		
	}
	
	@Override
	@Transactional
	public Booking viewBooking(int bokkingId) {
		
		log.debug("Inside viewBooking method in BookingService class");
		
		Optional<Booking>BookingOpt= bookingRepository.findById(bokkingId);
		
		return BookingOpt.get();
		
		
	}
	
	@Override
	@Transactional
	public void deleteBooking(int bookingId) {
		
		log.debug("Inside deleteBooking method in BookingService class");
		
		bookingRepository.deleteById(bookingId);
		
	}
	
	@Override
	@Transactional
	public List<Booking> viewAllBooking(BigInteger userId){
		
		log.debug("Inside viewAllBooking method in BookingService class");
		
		return bookingRepository.viewAllBooking(userId);
		
	}
	
	 @Override
	@Transactional
	public Booking modifyBooking(Booking booking)
	{
		 log.debug("Inside modifyBooking method in BookingService class");
		 
		return bookingRepository.save(booking);
	}
	

}

