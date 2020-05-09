package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="flight_table")
public class Flight {
	
	
	@Id
	@Column(name="flightNumber")
    BigInteger flightNumber;
	
	
	@Column(name="carrierName")
	String carrierName;
	
	@Column(name="flightModel")
	 String flightModel;
	
	@Column(name="seatCapacity")
     int seatCapacity;
	
	@Column(name="status")
	String status;

	public Flight() {	
		super();
	}
	
	
	public Flight(BigInteger flightNumber, String carrierName, String flightModel, int seatCapacity, String status) {	 
		
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
		this.status=status;
	}
	
	
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", carrierName=" + carrierName + ", flightModel=" + flightModel
			+ ", seatCapacity=" + seatCapacity + "]";
	}
	
	public BigInteger getFlightNumber() {
	return flightNumber;
	}
	
	
	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	
	public String getCarrierName() {
		return carrierName;
	}
	
	
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
	
	public String getFlightModel() {
		return flightModel;
	}
	
	
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	
	
	public int getSeatCapacity() {
		return seatCapacity;
	}
	
	
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	



}

