package com.capgemini.flightmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.flightmanagement.entity.Passenger;
import com.capgemini.flightmanagement.repository.IPassengerRepository;


@Service
public class PassengerService implements IPassengerService{

	
	@Autowired
	private IPassengerRepository passengerRepository;
	
	@Override
	@Transactional
	public void saveAll(List<Passenger> passengerList) {
		
		passengerRepository.saveAll(passengerList);
	}
}

