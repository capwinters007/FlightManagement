package com.capgemini.flightmanagement.service;


import java.util.List;

import com.capgemini.flightmanagement.entity.Passenger;


public interface IPassengerService {
	
	public void saveAll(List<Passenger> passengerList);

}

