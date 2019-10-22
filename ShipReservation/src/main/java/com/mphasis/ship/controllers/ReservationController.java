package com.mphasis.ship.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;
import com.mphasis.ship.services.PassengerService;
import com.mphasis.ship.services.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	PassengerService passengerService;
	
	@RequestMapping(value="/passenger",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addPassenger(@RequestBody Passenger passenger){
		try {
			passengerService.addPassenger(passenger);
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/passengers/{bookingId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Passenger> viewPassengers(@PathVariable("bookingId")String bookingId){
		List<Passenger> passengers=null;
		try {
			passengers=passengerService.getPassengers(bookingId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return passengers;
	}
	@RequestMapping(value="/book",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void book(@RequestBody Reservation reservation) {
		try {
			reservationService.book(reservation);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/ticket/{bookingId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Reservation getTicket(@PathVariable("bookingId")String bookingId) {
		Reservation res=null;
		try {
			res=reservationService.getTicket(bookingId);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	@RequestMapping(value="/cancel/{bookingId}/{status}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	 public void cancelTicket(@PathVariable("bookingId")String bookingId,@PathVariable("status")String status) {
		try {
			reservationService.cancelTicket(bookingId,status);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
	@RequestMapping(value="/update/{shipId}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateSeats(@PathVariable("shipId")String shipId) {
		try {
			reservationService.updateSeats(shipId);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/tickets/{userId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reservation> getTicketDetails(@PathVariable("userId")String userId){
		List<Reservation> reservations=null;
		try {
			reservations=reservationService.getTicketDetails(userId);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return reservations;
	}
}

