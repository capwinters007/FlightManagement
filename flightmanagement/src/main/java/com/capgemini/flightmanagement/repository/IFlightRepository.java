package com.capgemini.flightmanagement.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, BigInteger>{

}
