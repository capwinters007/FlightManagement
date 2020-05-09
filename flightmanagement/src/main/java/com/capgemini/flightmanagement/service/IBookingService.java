package com.capgemini.flightmanagement.service;


import java.math.BigInteger;
import java.util.List;
import com.capgemini.flightmanagement.entity.Booking;



public interface IBookingService {

	public Booking addBooking(Booking booking);
	public List<Booking> viewAllBooking(BigInteger userId);
    public Booking modifyBooking(Booking booking);
    public Booking viewBooking(int bookingId);
    public void deleteBooking(int bookingId);

	
	
	
	
}
