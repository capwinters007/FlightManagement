package com.capgemini.flightmanagement.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Booking;

@Repository
public interface IBookingRespository extends JpaRepository<Booking, Integer>{
	
	@Query("Select b from Booking b where b.userId=?1")
	List<Booking> viewAllBooking(BigInteger userId);

}
