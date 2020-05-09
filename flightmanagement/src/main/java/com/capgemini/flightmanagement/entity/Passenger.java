package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger_table")
public class Passenger {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PNR_Number",unique=true, nullable=false)
	BigInteger pnrNumber;
	
	@Column(name="PassengerName")
	String passengerName;
	
	@Column(name="PassengerAge")
	Integer passengerAge;
	
	@Column(name="PassengerUIN",unique=true, nullable=false)
	BigInteger passengerUIN;
	
	@Column(name="Luggage")
	int Luggage;
	

	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", Luggage=" + Luggage + "]";
	}
	public Passenger() {
		super();
	}
	public Passenger( String passengerName, Integer passengerAge, BigInteger passengerUIN,
			int luggage) {
		super();
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.Luggage = luggage;
	}
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public int getLuggage() {
		return Luggage;
	}
	public void setLuggage(int luggage) {
		Luggage = luggage;
	}
	
}
