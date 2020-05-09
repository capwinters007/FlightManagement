package com.capgemini.flightmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport_table")
public class Airport {

	@Id
	@Column(name="airportCode")
	String airportCode;
			
	@Column(name="airportName")
	String airportName;
		
	@Column(name="airportLocation")
	String airportLocation;

	public Airport() {
 
		super();
	}
	
	
	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	
	
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation=" + airportLocation
				+  "]";
	}
	
	
	public String getAirportCode() {
		return airportCode;
	}
	
	
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	
	public String getAirportName() {
		return airportName;
	}
	
	
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	
	public String getAirportLocation() {
		return airportLocation;
	}
	
	
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
}

