package com.mphasis.ship.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;

enum Status{
	confirmed, waitinglist, cancelled
}
@Entity
public class Reservation { 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "bok_seq")
	@GenericGenerator(name = "bok_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "BO_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String bookingId;
	@ManyToOne
	@JoinColumn(name="userId")
	private UserProfile user;
	@Column(precision=10, scale=2,nullable=false)
	private double totalFare;
	@ManyToOne
	@JoinColumn(name="shipId")
	private Ship ship;
	@OneToMany(mappedBy="reservation",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Passenger> passenger=new ArrayList<Passenger>();
	@Column(length=20,nullable=false)
	private String cardNo;
	@Column(length=10,nullable=false)
	private int pin;
	private Status status;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	}
