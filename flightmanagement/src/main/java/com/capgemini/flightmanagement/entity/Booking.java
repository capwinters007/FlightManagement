package com.capgemini.flightmanagement.entity;


import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="booking_table")
public class Booking {
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookingId_Sequence")
	@SequenceGenerator(name="bookingId_Sequence", sequenceName="BOOKINGID_SEQ")
	@Column(name="Booking_Id",unique=true, nullable=false)
	private int bookingId;
	
	@Column(name="userId")
	private BigInteger userId;

	@Column(name="bookingDate")
	private LocalDate bookingDate;
	
	@OneToMany(cascade = {CascadeType.ALL},targetEntity=Passenger.class)
	@JoinColumn(name="passengerBID" )
	private List<Passenger> passengerList;
	

	@Column(name="ticketCost")
	private Double ticketCost;
	
	@OneToOne
	@JoinColumn(name="flightNumber")
	private FlightSchedule flightSchedule;

	
	@Column(name="noOfPassengers")
	private int noOfPassengers;
	
	public Booking() {
		super();
	}

	public Booking( BigInteger userId, LocalDate bookingDate, List<Passenger> passengerList, Double ticketCost,
			FlightSchedule flightSchedule, int noOfPassengers) {
		super();
		
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flightSchedule = flightSchedule;
		this.noOfPassengers = noOfPassengers;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BigInteger getUser() {
		return userId;
	}

	public void setUser(BigInteger userId) {
		this.userId = userId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flight) {
		this.flightSchedule = flight;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flightSchedule=" + flightSchedule
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}
	
	

	
	
	

	
}

