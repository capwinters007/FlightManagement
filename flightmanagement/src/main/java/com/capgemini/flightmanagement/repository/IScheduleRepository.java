package com.capgemini.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{

}
