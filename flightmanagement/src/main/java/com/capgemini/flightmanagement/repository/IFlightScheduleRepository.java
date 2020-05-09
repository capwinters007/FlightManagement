package com.capgemini.flightmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.entity.FlightSchedule;

@Repository
public interface IFlightScheduleRepository extends JpaRepository<FlightSchedule, Integer>{

	@Query("Select f from FlightSchedule f join f.schedule s where s.sourceAirport=?1 and s.destinationAirport=?2")
	List<FlightSchedule> getFlightScheduleByAirport(Airport source,Airport destination);
	
}
