package com.capgemini.flightmanagement.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.Passenger;

@Service
public interface IPassengerRepository extends JpaRepository<Passenger, BigInteger>{

}
