package com.capgemini.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Airport;


@Repository
public interface IAirportRepository extends JpaRepository<Airport, String>{

}
